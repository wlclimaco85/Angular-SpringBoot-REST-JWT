/*==========================================================
    Author      : Ranjithprabhu K
    Date Created: 27 Dec 2015
    Description : This service is to communicate with server for CRUD Operaions
    
    Change Log
    s.no      date    author     description     
 ===========================================================*/

app.service('apiService', ['$http', '$q', 'appSettings', function($http, $q, appSettings) {

    var apiService = {};
    var apiBase = appSettings.apiBase;

    //===========================GET RESOURCE==============================
    var get = function(module, parameter) {
        var deferred = $q.defer();
        $http.get(apiBase + module, { params: parameter }, { headers: { 'Content-Type': 'application/json' } }).success(function(response) {
            deferred.resolve(response);
        }).catch(function(data, status, headers, config) { // <--- catch instead error
            deferred.reject(data.statusText);
        });

        return deferred.promise;
    };

    //===========================CREATE RESOURCE==============================
    var create = function(module, parameter) {
        console.log("hitting Service=============");

        var deferred = $q.defer();

        $http.post(apiBase + module, parameter, { headers: { 'Content-Type': 'application/json' } }).success(function(response) {

            deferred.resolve(response);

        }).catch(function(data, status, headers, config) { // <--- catch instead error
            deferred.reject(data.statusText);
        });

        return deferred.promise;
    };


    //===========================UPDATE RESOURCE==============================
    var update = function(module, parameter) {
        console.log("hitting Service=============");

        var deferred = $q.defer();

        $http.post(apiBase + module + '/' + parameter.id, parameter, { headers: { 'Content-Type': 'application/json' } }).success(function(response) {

            deferred.resolve(response);

        }).catch(function(data, status, headers, config) { // <--- catch instead error
            deferred.reject(data.statusText);
        });

        return deferred.promise;
    };


    //===========================DELETE RESOURCE==============================
    var delet = function(module, parameter) {
        console.log("hitting Service=============");

        var deferred = $q.defer();

        $http.post(apiBase + module + '/' + parameter.id, parameter, { headers: { 'Content-Type': 'application/json' } }).success(function(response) {

            deferred.resolve(response);

        }).catch(function(data, status, headers, config) { // <--- catch instead error
            deferred.reject(data.statusText);
        });

        return deferred.promise;
    };

    //===========================DELETE RESOURCE==============================
    var processLogin = function(_url, _req, _callback) {
        console.log("LOGIN Service=============");

        var deferred = $q.defer();
        debugger
        //   $http.post(_url, _req, { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } })
        $http.post(_url, _req, { headers: { 'Content-Type': 'application/json' } }).success(function(response) {
            //$http.post(_url + module + '/' + parameter.id, parameter, { headers: { 'Content-Type': 'application/json' } }).success(function(response) {
            //  _callback(response.data);
            deferred.resolve(response);

        }).catch(function(data, status, headers, config) { // <--- catch instead error
            deferred.reject(data.statusText);
        });

        return deferred.promise;

        // var res = $http.post(_url, _req, { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } });
        // res.then(function(response) {
        //     _callback(response.data);
        // })
    };





    apiService.get = get;

    apiService.create = create;
    apiService.update = update;
    apiService.delet = delet;
    apiService.login = processLogin;

    return apiService;

}]);