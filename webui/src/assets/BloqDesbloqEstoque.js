/*
 *Createad by Washington Costa 22/07/2019.
 */
angular
    .module('BloqDesbloqEstoqueApp', ['snk'])
    .controller('BloqDesbloqEstoqueController', ['ObjectUtils', 'SkApplicationInstance', 'MessageUtils', 'i18n',
        function(ObjectUtils, SkApplicationInstance, MessageUtils, i18n) {
            debugger
            var self = this

            ObjectUtils.implements(self, IDynaformInterceptor);
            ObjectUtils.implements(self, IDatagridInterceptor);
            ObjectUtils.implements(self, IFormInterceptor);

            self.onDynaformLoaded = onDynaformLoaded;
            self.acceptField = acceptField;
            self.acceptColumnField = acceptColumnField;
            self.interceptField = interceptField;

            var _codUsuLogado = SkApplicationInstance.getUserID();

            function onDynaformLoaded(dynaform, dataset) {
                if (dynaform.getEntityName() == 'BloqDesbloqEstoque') {
                    self.dsBloqDesbloqEstoque = dataset;

                    dataset.beforePostAction(function(dataset) {
                        if (dataset.getFieldValue('QTD') != null && dataset.getFieldValue('QTD') < 0) {
                            MessageUtils.showAlert("Aviso", i18n('armazem.BloqDesbloqEstoque.msgValidaQtdNegativo'));
                            return false;
                        }
                        if (dataset.getFieldValue('SINAL') == 1) {
                            dataset.setFieldValue('DTALTERBLOQ', new Date());
                            dataset.setFieldValue('CODUSUBLOQ', _codUsuLogado);
                        } else if (dataset.getFieldValue('SINAL') == -1) {
                            dataset.setFieldValue('DTALTERDES', new Date());
                            dataset.setFieldValue('CODUSUDES', _codUsuLogado);
                        }
                        return true;
                    });

                    dynaform.getNavigatorAPI()
                        .showCopyButton(false)
                        .showRemoveButton(false)
                        .showAddButton(true)
                        .showEditButton(false)
                        .showCancelButton(true)
                        .showSaveButton(true);

                    self.dsBloqDesbloqEstoque.addInsertionModeListener(function() {
                        dynaform.setFieldProperty('DTALTERBLOQ', 'visible', false);
                        dynaform.setFieldProperty('CODUSUBLOQ', 'visible', false);
                        dynaform.setFieldProperty('DTALTERDES', 'visible', false);
                        dynaform.setFieldProperty('CODUSUDES', 'visible', false);
                        self.dsBloqDesbloqEstoque.setFieldValue('DTALTER', new Date());
                        self.dsBloqDesbloqEstoque.setFieldValue('CODUSU', _codUsuLogado);
                        self.dsBloqDesbloqEstoque.setFieldValue('TIPO', "M");
                    });


                    self.dsBloqDesbloqEstoque.getFieldsMetadata().forEach(function(field) {
                        if (['DTALTER', 'CODUSU'].indexOf(field.name) > -1) {
                            field.visible = false;
                        }
                        if (['SALDODIS', 'DTALTERBLOQ', 'CODUSUBLOQ'].indexOf(field.name) > -1) {
                            field.properties.push({ name: 'enabled', value: true });
                        }
                        if (['DTALTERBLOQ', 'CODUSUBLOQ'].indexOf(field.name) > -1) {
                            field.properties.push({ name: 'enabled', value: true });
                        }
                    });

                    self.dsBloqDesbloqEstoque.addLineChangeListener(function(newIndex) {
                        if (newIndex > -1) {
                            isBloqueio = (self.dsBloqDesbloqEstoque && self.dsBloqDesbloqEstoque.getFieldValue('SINAL') > 0);
                            dynaform.setFieldProperty('DTALTERBLOQ', 'visible', isBloqueio);
                            dynaform.setFieldProperty('CODUSUBLOQ', 'visible', isBloqueio);
                            dynaform.setFieldProperty('DTALTERDES', 'visible', !isBloqueio);
                            dynaform.setFieldProperty('CODUSUDES', 'visible', !isBloqueio);
                        }
                    });
                }
            }


            function acceptField(fieldMD, dynaform, dataset) {
                if (dataset.getEntityName() == 'BloqDesbloqEstoque') {
                    return !(['TIPO'].indexOf(fieldMD.name) > -1);
                }
            }

            function acceptColumnField(fieldMD, dataset) {
                return acceptField(fieldMD, undefined, dataset);
            }

            function interceptField(fieldMetadata) {

                if (['DTALTERBLOQ', 'CODUSUBLOQ'].indexOf(field.name) > -1) {
                    fieldMetadata['enabled'] = true;
                }
            }
        }
    ]);