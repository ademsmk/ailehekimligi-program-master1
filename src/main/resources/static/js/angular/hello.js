var app = angular.module('myApp', [ 'ngRoute' ,'ngStorage' ,"ngTable"  ]).config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'controller',
		controllerAs : 'controller'
	}).when('/kurum', {
		templateUrl : 'kurum.html',
		controller : 'kurumController',
		controllerAs : 'demo'
	}).when('/doktor', {
		templateUrl : 'doktor.html',
		controller : 'doktorController',
		controllerAs : 'demo'
	}).when('/tani', {
		templateUrl : 'tani.html',
		controller : 'taniController',
		controllerAs : 'demo'
	}).when('/nufusKaydi', {
		templateUrl : 'nufusKaydi.html',
		controller : 'nufusController',
		controllerAs : 'demo'
	}).when('/hastaBilgi', {
		templateUrl : 'hasta.html',
		controller : 'hastaBilgisiController',
		controllerAs : 'demo'
	}).when('/tahlil', {
		templateUrl : 'tahlil.html',
		controller : 'tahlilController',
		controllerAs : 'demo'
	}).when('/recete', {
		templateUrl : 'recete.html',
		controller : 'receteController',
		controllerAs : 'demo'
	}).otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).controller('controller',
		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams) {
	
		console.log("basladık");
}).service('mainServices', function ($http) 
		{
		var self = this;	

		self.getData = function() {
	        // $http() returns a $promise that we can add handlers with .then()
	         return $http({
	            method: 'GET',
	            url: '/kurumListele',
	         });
	     }
		
		self.getDoktors = function() {
	        // $http() returns a $promise that we can add handlers with .then()
			return $http({
				url:'/doktor/doktorListele',
				method: 'GET'   
			});
	     }
		self.getTahlil = function() {
	        // $http() returns a $promise that we can add handlers with .then()
			return $http({
				url:'/tahlil/tahlilListele',
				method: 'GET'   
			});
	     }
		
		self.getNufus = function() {
	        // $http() returns a $promise that we can add handlers with .then()
			return $http({
				url:'/nufus/nufusBilgisiListele',
				method: 'GET'   
			});
	     }
		
		self.getTani = function() {
	        // $http() returns a $promise that we can add handlers with .then()
			return $http({
				url:'/tani/taniListele',
				method: 'GET'   
			});
	     }
		self.getRecete = function() {
	        // $http() returns a $promise that we can add handlers with .then()
			return $http({
				url:'receteListele',
				method: 'GET'   
			});
	     }
	
		});
