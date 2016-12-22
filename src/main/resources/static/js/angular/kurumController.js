	angular.module('myApp').controller('kurumController',
	function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {
	
	var self = this;

	self.originalData = {};
	self.data2 = null;
	mainServices.getData().then(function(dataResponse) {
		
//		self.kurum = JSON.parse(dataResponse.data);
		self.originalData = angular.copy(dataResponse.data);
		self.tableParams = new NgTableParams({}, { dataset: self.originalData});	
    });
	
	 
	
	
	
//    var originalData = angular.copy(simpleList);
    
//	self.data = Service.myFunc();
//    self.tableParams = new NgTableParams({}, { dataset: self.data});
    
//    self.tableParams = new NgTableParams({}, {
//      filterDelay: 0,
//      dataset: angular.copy(simpleList)
//    });

    self.cancel = cancel;
    self.del = del;
    $rootScope.kurumlar = {};
    $rootScope.kurum_adi;
    $rootScope.kurum_adres;
    $rootScope.kurum_tel;
    //////////

    function cancel(row, rowForm) {
      var originalRow = resetRow(row, rowForm);
      angular.extend(row, originalRow);
    }

    function del(user) {
    	var del = user.kurum_Kodu;
    	
    	$http({
    		url:'/kurumSil',
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
    			kurum_Adi: self.kurumadi,
    			kurum_Adres: self.kurumadres,
    			kurum_Tel: self.kurumtel
    	       };	
    	
    	$http({
    		url:'/kurumekle',
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