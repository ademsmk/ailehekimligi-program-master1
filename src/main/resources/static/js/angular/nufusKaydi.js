angular.module('myApp').controller('nufusController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		
		self.originalData = {};	
		mainServices.getNufus().then(function(dataResponse) {
			self.originalData = angular.copy(dataResponse.data);
			self.tableParams = new NgTableParams({}, { dataset: self.originalData});	
	    });
		
		self.del = function del(user) {
	    	
	    	$http({
	    		url:'nufus/nufusBilgisiSil',
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
			var data = {  			
    			hasta_Tc: self.hasta_Tc,
    			hasta_Adi: self.hasta_Adi,
    			hasta_Soyadi: self.hasta_Soyadi,
    			dog_Tar : self.dog_Tar,
    			dog_Yeri :self.dog_Yeri,
    			baba_Adi : self.baba_Adi,
    			anne_Adi : self.anne_Adi,
    			medeni_Durum : self.medeni_Durum,
    			cinsiyet : self.cinsiyet,
    			uyruk : self.uyruk,
    			il : self.il
    	       };	
			$http({
	    		url:'nufus/nufusBilgisiekle',
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