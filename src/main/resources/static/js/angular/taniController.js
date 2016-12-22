angular.module('myApp').controller('taniController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		
		self.originalData = {};
		self.orginalData = {};
		mainServices.getTani().then(function(dataResponse) {
			self.originalData = angular.copy(dataResponse.data);
			self.tableParams = new NgTableParams({}, { dataset: self.originalData});
			
			
	    });
		
		self.del = function del(user) {
	    	
	    	$http({
	    		url:'/tani/taniSil',
	    		method: 'POST', 
	    		data: user
	    	}).then(function(response) {
	        	if(response.data.success)
	    		{
	        		var index = self.originalData.indexOf(user);
	      		  	if(index>=0)
	      			  self.originalData.splice(index, 1);
	      		  	
	        	      self.tableParams.reload().then(function(data) {
	        	        if (data.length === 0 && self.tableParams.total() > 0) {
	        	          self.tableParams.page(self.tableParams.page() - 1);
	        	          self.tableParams.reload();
	        	        }
	        	      });
	    		}
	        	else
	        		alert("hata");
	    	});

	    }
		
		self.addRow = function(form){		
	    	var data ={  			
	    			tani_Adi : self.tani_Adi
	    	};
			$http({
	    		url:'/tani/taniekle',
	    		method: 'POST', 
	    		data: data   
			}).then(function(response) {
		    	if(response.data.success)
	    		{
		    		self.originalData.splice(0, 0, data);
		    		self.tableParams.reload();
	    		}
			});

	    };

		
		
		});