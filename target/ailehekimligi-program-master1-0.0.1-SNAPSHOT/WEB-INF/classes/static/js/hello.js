angular.module('myApp', [ 'ngRoute' ,'ngStorage' ]).config(function($routeProvider, $httpProvider) {

	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'controller',
		controllerAs : 'controller'
	}).when('/login', {
		templateUrl : 'login.html',
		controller : 'controller',
		controllerAs : 'controller'
	}).otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

}).controller('controller',

		function($rootScope, $http, $location, $route ,$sessionStorage) {
		
		var self = this;
		self.username ="";
		self.password="";
		$rootScope.sessionUser = $sessionStorage.user;
		self.currentUser = {};
		$rootScope.users = $sessionStorage.users;
		
		self.login = function()
		{
			$http({
	    		url:'user',
	    		method: 'POST', 
	    		data: "username=" + self.username.value + "&password="+ self.password.value, 
	    })
		    .then(function(response) {
		    	if(response)
		    		{
		    		console.log("Login succeeded");
					$location.path('/users');
					$rootScope.error = false;
					
					self.currentUser.username = self.username;
					$sessionStorage.user = self.currentUser;
					
					
					$http({
						  method: 'GET',
						  url: '/getUsers'
						}).then(function(response) {
							if(response)
								{
									$rootScope.users = response.data;
									$sessionStorage.users = $rootScope.users;								
								}
						  });

		    		}
		    	else
		    	{
		    		console.log("Login failed");
					$location.path();
					$rootScope.error = true;
					$sessionStorage.user = null;
		    	}
			});
		}
		
		self.logout = function()
		{
			$route.reload();
			$sessionStorage.user = null;
		}
		
		self.remove=function($index){ 
			
			self.userid = $rootScope.users[$index].id;
			$http({
				  method: 'GET',
				  url: '/removeUser',
				  data : 'userid=' + self.userid
				}).then(function(response) {
					if(response.data)
						{
							$rootScope.users.splice($index,1); 
							$sessionStorage.users = $rootScope.users;	
							$rootScope.error = true;
						}
					else
						{
						$rootScope.error = true;
						}
				  });
			
			    
		}
		
		
		});
