angular.module('myApp').controller('hastaBilgisiController',

		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {		
		var self = this;
		self.orginalData = {};
		
		$http({
			url:'/hastabilgisi/hastaListele',
			method: 'GET'   
		}).then(function(response) {
	    	if(response.data)
			{
	    		//return response.data;
	    		self.originalData = angular.copy(response.data);
				self.tableParams = new NgTableParams({}, { dataset: self.originalData});
			}
		});
		
		mainServices.getNufus().then(function(dataResponse) {
			self.hastalar = dataResponse.data;	
	    });
		
		mainServices.getDoktors().then(function(dataResponse) {
			self.doktorlar = dataResponse.data;	
	    });
		
		
		mainServices.getData().then(function(dataResponse) {
			self.kurumlar = dataResponse.data;	
	    });
		
		self.del = function(user) {
	    	
	    	$http({
	    		url:'/hastabilgisi/hastaSil',
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
	        		alert("hata");
	    	});

	    }
		
		self.addRow = function(form){		
	    	var data = {  			
	    		nufusKaydi : JSON.parse(self.hasta),
	    		sosyal_Guvencesi: self.sosyal_Guvencesi,
	    		meslegi: self.meslegi,
	    		hasta_Telno : self.hasta_Telno,
	    		hasta_Adres :self.hasta_Adres,
	    		doktor : JSON.parse(self.doktor)
    	       };	
			$http({
	    		url:'/hastabilgisi/hastaekle',
	    		method: 'POST', 
	    		data : angular.toJson(data)
	    		   
			}).then(function(response) {
		    	if(response.data.success)
	    		{	
		    		self.originalData.splice(0, 0, data);
		    		self.tableParams.reload();
	    		}
			});

	    };

		
		
		});