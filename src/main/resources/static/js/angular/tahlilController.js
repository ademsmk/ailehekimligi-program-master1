angular.module('myApp').controller('tahlilController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		
		
		mainServices.getData().then(function(dataResponse) {
			self.kurumlar = dataResponse.data;	
	    });
		
		self.orginalData = {};
		mainServices.getTahlil().then(function(dataResponse) {
			self.originalData = angular.copy(dataResponse.data);
			self.tableParams = new NgTableParams({}, { dataset: self.originalData});
			
			
	    });
		
		self.form = {};
		self.show = false;
		
		self.del = function(user) {
	    	
	    	$http({
	    		url:'/tahlil/tahlilSil',
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
	    			
	    			kolestrol: self.kolestrol,
	    			tamkan: self.tamkan,
	    			demir: self.demir,
	    			demir_Baglama: self.demir_Baglama,
	    			alt: self.alt,
	    			ast: self.ast,
	    			glikoz : self.glikoz,
	    			crp :self.crp,
	    			glikoz : self.glikoz,
	    			tamidrar :self.tamidrar
	    	       };	
			$http({
	    		url:'/tahlil/tahlilekle',
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