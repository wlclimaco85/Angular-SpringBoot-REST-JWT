/*==========================================================
    Author      : Ranjithprabhu K
    Date Created: 24 Dec 2015
    Description : Controller to handle Login module
    Change Log
    s.no      date    author     description     


 ===========================================================*/

login.controller("loginCtrl", ['$rootScope', '$scope', '$state', '$location', 'loginService', 'Flash', 'apiService', 'localStorageService',

    function($rootScope, $scope, $state, $location, loginService, Flash, apiService, localStorageService) {
        var vm = this;
        vm.getUser = {};
        vm.setUser = {};
        vm.signIn = true;


        vm.login = function() {

            apiService.login("http://localhost:9119/session", { username: 'demo', password: 'demo' }, null).then(function(authenticationResult) {
                //    apiService.login("http://localhost:9119/session", $.param({ username: 'demo', password: 'demo' }), function(authenticationResult) {
                debugger
                var authToken = authenticationResult.item.token;

                if (authToken !== undefined) {
                    $rootScope.authToken = authToken;
                    localStorageService.set('authToken', authToken);
                    $state.go('app.dashboard');

                    //     var currentUser = { user: authenticationResult.name, roles: authenticationResult.roles };
                    //     $rootScope.user = currentUser;

                    //     SysMgmtData.processPostPageData("main/api/request", {
                    //         url: "entidade/api/empresa/fetchUser",
                    //         token: authToken,
                    //         request: new qat.model.empresaInquiryRequest(100 / 20, true, currentUser.user, null, null)
                    //     }, function(res) {
                    //         if (res.operationSuccess == true) {
                    //             localStorageService.set('empresa', res.empresaList[0]);
                    //             localStorage.setItem("empresa", JSON.stringify(res.empresaList[0]));
                    //             qat.model.select.util("entidade/api/doisValores/fetchPage", true, new qat.model.doisValoresInquiryRequest(null, 100 / 20, true, JSON.parse(localStorage.getItem("empresa")).id),
                    //                 function(ress) {
                    //                     localStorageService.set('doisValores', ress.doisValoresList);
                    //                 });



                    //             if (res.empresaList[0].primeiroAcesso == 0) {
                    //                 if (res.empresaList[0].tipo == 1) {
                    //                     dialogFactory.dialog('views/util/dialog/dPrimeiraAdvocacia.html', "ClienteInsertController", validationFactory.cliente, function() {});
                    //                 } else if (res.empresaList[0].tipo == 2) {
                    //                     dialogFactory.dialog('views/cadastros/dialog/dPrimeiraClinica.html', "ClienteInsertController", validationFactory.cliente, function() {});
                    //                 } else if (res.empresaList[0].tipo == 3) {
                    //                     dialogFactory.dialog('views/cadastros/dialog/dPrimeiraCondominio.html', "ClienteInsertController", validationFactory.cliente, function() {});
                    //                 } else if (res.empresaList[0].tipo == 4) {
                    //                     dialogFactory.dialog('views/cadastros/dialog/dPrimeiraContador.html', "ClienteInsertController", validationFactory.cliente, function() {});
                    //                 } else if (res.empresaList[0].tipo == 5) {
                    //                     dialogFactory.dialog('views/cadastros/dialog/dPrimeiraEmpresa.html', "ClienteInsertController", validationFactory.cliente, function() {});
                    //                 } else if (res.empresaList[0].tipo == 6) {
                    //                     //	dialogFactory.dialog('views/util/dialog/dPrimeiraEmpresa.html', "ClienteInsertController", validationFactory.cliente, function(){});
                    //                     var _close = function() { console.log('close') };
                    //                     ModalService.showModal({
                    //                         templateUrl: 'views/util/dialog/dPrimeiraEmpresa.html',
                    //                         controller: "NewEmpresaUpdateController"
                    //                     }).then(function(modal) {
                    //                         modal.element.modal();
                    //                         modal.close.then(function(result) {
                    //                             if ((_close != null) && (_close != undefined))
                    //                                 _close();
                    //                         });
                    //                     });
                    //                 } else {
                    //                     dialogFactory.dialog('views/cadastros/dialog/dPrimeiraEmpresa.html', "ClienteInsertController", validationFactory.cliente, function() {});
                    //                 }
                    //             }
                    //         }
                    //     });


                    //     SysMgmtData.processPostPageData("main/api/request", {
                    //         url: "entidade/api/transaction/fetch",
                    //         token: authToken,
                    //         request: new qat.model.transactionInquiryRequest(new qat.model.transaction(currentUser.user, authToken), 100 / 20, true, currentUser.user, null, null)
                    //     }, function(res) {
                    //         if (res.operationSuccess == true) {
                    //             localStorageService.set('transaction', res.transactionList[0].id);
                    //             localStorage.setItem("transaction", JSON.stringify(res.transactionList[0]));
                    //         }
                    //     });


                    //     $rootScope.main.name = authenticationResult.name;
                    //     localStorageService.set('currentUser', $rootScope.user);
                    //     var tempRole = "";
                    //     for (var prop in authenticationResult.roles) {
                    //         tempRole += prop + " ";
                    //     }
                    //     $rootScope.displayRoles = tempRole;
                    //     localStorageService.set('displayRoles', $rootScope.displayRoles);

                    //     if ($rootScope.callingPath !== undefined) {
                    //         if ($rootScope.callingPath === '/pages/signin') {
                    //             $rootScope.callingPath = "/principal";

                    //         }
                    //         $location.path($rootScope.callingPath);
                    //     } else {
                    //         $location.path("/dashboard");
                    //     }
                    // } else {
                    //     $location.path("/pages/signin");
                } else {
                    Flash.create('danger', 'Invalid Password', 'large-text');
                }
            });
        };

        // //access login
        // vm.login = function(data) {
        //     if (data.Username == "admin") {
        //         if (data.Password == "admin") {
        //             $state.go('app.dashboard');
        //         } else
        //             Flash.create('danger', 'Invalid Password', 'large-text');
        //     } else
        //         Flash.create('danger', 'Invalid Username', 'large-text');
        // };

        //get registration details
        vm.register = function() {
            if (vm.setUser.confirmPassword == vm.setUser.Password) {
                loginService.registerUser(vm.setUser).then(function(response) {
                    if (response.message == 'success')
                        console.log('after post>>', response);
                    //if (response.length > 0)
                    //    $state.go('app');
                    //else
                    //    Flash.create('danger', 'Invalid Credentials', 'large-text');
                });
            }
        };

    }
]);