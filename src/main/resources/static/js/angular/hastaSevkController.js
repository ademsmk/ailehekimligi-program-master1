angular.module('myApp').controller('hastaSevkController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		
		self.originalData = {};
		mainServices.getBolum().then(function(dataResponse) {
			self.bolumler = dataResponse.data;	
	    });
		
		mainServices.getSevk().then(function(dataResponse) {
			self.originalData = angular.copy(dataResponse.data);
			self.tableParams = new NgTableParams({}, { dataset: self.originalData});	
	    });
		
		self.del = function(user) {
	    	
	    	$http({
	    		url:'/hastaSevkSil',
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
	    			hastane_Adi: self.hastane_Adi,
	    			sevk_tarihi: self.sevk_tarihi,
	    			sevk_tarihi: self.sevk_tarihi,
	    			hasta_Adi : self.hasta_Adi,
	    			hasta_Soyadi :self.hasta_Soyadi,
	    			hasta_Sikayet : self.hasta_Sikayet,
	    			bolum :JSON.parse(self.bolum)
	    	       };	
			$http({
	    		url:'/hastaSevkekle',
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