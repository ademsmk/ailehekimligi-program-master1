
angular.module('myApp').controller('randevuController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		
		
		mainServices.getDoktors().then(function(dataResponse) {
			self.doktorlar = dataResponse.data;	
	    });
		
		mainServices.getNufus().then(function(dataResponse) {
			self.hastalar = dataResponse.data;	
	    });
		
		self.orginalData = {};
		mainServices.getRandevu().then(function(dataResponse) {
			self.originalData = angular.copy(dataResponse.data);
			self.tableParams = new NgTableParams({}, { dataset: self.originalData});
	    });
		
		
		self.del = function(user) {
	    	
	    	$http({
	    		url:'randevuSil',
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
	    			
	    			nufus: JSON.parse(self.nufus),
	    			doktor: JSON.parse(self.doktor),
	    			muayene_Tar: self.muayene_Tar,
	    	       };	
			$http({
	    		url:'randevuekle',
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