angular.module('myApp').controller('doktorController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		
		
		mainServices.getData().then(function(dataResponse) {
			self.kurumlar = dataResponse.data;	
	    });
		
		self.orginalData = {};
		mainServices.getDoktors().then(function(dataResponse) {
			self.originalData = angular.copy(dataResponse.data);
			self.tableParams = new NgTableParams({}, { dataset: self.originalData});
	    });
		
		mainServices.getNufus().then(function(dataResponse) {
			self.nufus = dataResponse.data;	
	    });
		
		self.del = function(user) {
	    	
	    	$http({
	    		url:'/doktor/doktorSil',
	    		method: 'POST', 
	    		data: user
	    	}).then(function(response) {
	        	if(response.data.success)
	    		{
	        		//$rootScope.kurumlar = response.data;
	        		//$rootScope.kurumlar.splice($index,1);
	        		
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
	        		alert("kurum silmek için altındaki hastlarında silinmesi gerekmektedir.");
	    	});

	    }
		
		self.addRow = function(form){		
	    	var data = {  			
	    			dr_Adi: self.dr_Adi,
	    			dr_SoyAdi: self.dr_SoyAdi,
	    			dr_Tel: self.dr_Tel,
	    			dr_Mail : self.dr_Mail,
	    			kurum :JSON.parse(self.kurum)
	    	       };	
			$http({
	    		url:'/doktor/doktorekle',
	    		method: 'POST', 
	    		data:  data  
			}).then(function(response) {
		    	if(response.data.success)
	    		{
		    		self.originalData.splice(0, 0, data);
		    		self.tableParams.reload();
	    		}
			});

	    };

		
		
		});