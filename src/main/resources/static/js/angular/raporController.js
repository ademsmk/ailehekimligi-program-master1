angular.module('myApp').controller('raporController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		
		
		mainServices.getData().then(function(dataResponse) {
			self.kurumlar = dataResponse.data;	
	    });
		mainServices.getDoktors().then(function(dataResponse) {
			self.doktorlar = dataResponse.data;	
//			self.kurumlar = dataResponse.data.kurum;
	    });
		
		mainServices.getNufus().then(function(dataResponse) {
			self.hastalar = dataResponse.data;	
	    });
		mainServices.getTani().then(function(dataResponse) {
			self.tanilar = dataResponse.data;	
	    });
		
		mainServices.getRecete().then(function(dataResponse) {
			self.receteler = dataResponse.data;	
	    });
		
		self.orginalData = {};
		mainServices.getRapor().then(function(dataResponse) {
			self.originalData = angular.copy(dataResponse.data);
			self.tableParams = new NgTableParams({}, { dataset: self.originalData});
	    });
		
		
		self.del = function(user) {
	    	
	    	$http({
	    		url:'raporSil',
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
	    			kurum: JSON.parse(self.kurum),
	    			tani: JSON.parse(self.tani),
	    			rapor_Tar: self.rapor_Tar,
	    			rapor_Sure: self.rapor_Sure,
	    			recete : JSON.parse(self.recete)
	    	       };	
			$http({
	    		url:'raporekle',
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