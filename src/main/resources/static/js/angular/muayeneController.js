angular.module('myApp').controller('muayeneController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		
		
		mainServices.getTani().then(function(dataResponse) {
			self.tanilar = dataResponse.data;	
	    });
		
		mainServices.getRecete().then(function(dataResponse) {
			self.receteler = dataResponse.data;	
	    });
		
		mainServices.getTahlil().then(function(dataResponse) {
			self.tahliller = dataResponse.data;	
	    });
		
		self.orginalData = {};
		mainServices.getMuayene().then(function(dataResponse) {
			self.originalData = angular.copy(dataResponse.data);
			self.tableParams = new NgTableParams({}, { dataset: self.originalData});
	    });
		
		
		self.del = function(user) {
	    	
	    	$http({
	    		url:'muayeneSil',
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
	    };
		
		self.addRow = function(form){
			
	    	var data = { 
	    			tani: JSON.parse(self.tani),
	    			tahlil: JSON.parse(self.tahlil),
	    			recete: JSON.parse(self.recete),
	    			muayene_Tar: self.muayene_Tar,
	    			ates: self.ates,
	    			solunum : self.solunum,
	    			nabiz : self.nabiz,
	    			genel_Durum : self.genel_durum
	    	       };	
			$http({
	    		url:'muayeneekle',
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