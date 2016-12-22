//  angular.module('myApp').controller('dynamicDemoController',
//
//		function($rootScope, $http, $location, $route ,$sessionStorage,NgTableParams,mainServices) {
//    var self = this;
//    
//    
//    mainServices.getData().then(function(dataResponse) {
//    	self.tableParams = new NgTableParams({}, { dataset: dataResponse.data});
//    	var originalData = dataResponse.data;
//    });
//    
//    self.cols = [{
//	      field: "kurum_Adi",
//	      title: "Kurum Adi"
//	      }, {
//	      field: "kurum_Adress",
//	      title: "Kurum Adress"
//	    }, {
//	      field: "kurum_Tel",
//	      title: "Kurum Tel",
//	    }, {
//	      field: "action",
//	      title: "",
//	      dataType: "command"
//	    }];
//
//    self.deleteCount = 0;
//
//    self.add = add;
//    self.cancelChanges = cancelChanges;
//    self.del = del;
//    self.hasChanges = hasChanges;
//    self.saveChanges = saveChanges;
//
//    //////////
//
//    function add() {
//      self.isEditing = true;
//      self.isAdding = true;
//      self.tableParams.settings().dataset.unshift({
//    	  kurum_Adi: "",
//    	  kurum_Adress: "",
//    	  kurum_Telney: ""
//      });
//      // we need to ensure the user sees the new row we've just added.
//      // it seems a poor but reliable choice to remove sorting and move them to the first page
//      // where we know that our new item was added to
//      self.tableParams.sorting({});
//      self.tableParams.page(1);
//      self.tableParams.reload();
//    }
//
//    function cancelChanges() {
//      resetTableStatus();
//      var currentPage = self.tableParams.page();
//      self.tableParams.settings({
//        dataset: angular.copy(originalData)
//      });
//      // keep the user on the current page when we can
//      if (!self.isAdding) {
//        self.tableParams.page(currentPage);
//      }
//    }
//
//    function del(row) {
//      _.remove(self.tableParams.settings().dataset, function(item) {
//        return row === item;
//      });
//      self.deleteCount++;
//      self.tableParams.reload().then(function(data) {
//        if (data.length === 0 && self.tableParams.total() > 0) {
//          self.tableParams.page(self.tableParams.page() - 1);
//          self.tableParams.reload();
//        }
//      });
//    }
//
//    function hasChanges() {
//      return self.tableForm.$dirty || self.deleteCount > 0
//    }
//
//    function resetTableStatus() {
//      self.isEditing = false;
//      self.isAdding = false;
//      self.deleteCount = 0;
//      self.tableForm.$setPristine();
//    }
//
//    function saveChanges() {
//      resetTableStatus();
//      var currentPage = self.tableParams.page();
//      originalData = angular.copy(self.tableParams.settings().dataset);
//    }
//  });