describe('employee', function () {

  beforeEach(module('employeeApp'));

  var $controller,$rootScope;

  beforeEach(inject(function(_$controller_,_$rootScope_){
    $controller = _$controller_;
    $rootScope =_$rootScope_
  }));

  describe('update', function () {
        it('updateEmployee checking', function () {
            var $scope = $rootScope.$new();
            var controller = $controller('employeeController', { $scope: $scope });
            $scope.getUpdateEmployee({
                        'employeeId':108,
                        'firstName':'sid',
                        'lastName':'vora',
                        'email':'sid@gmail.com',
                        'phoneNumber':'9865463255',
                        'hireDate':'jhsdag',
                        'jobId':'AC_MGR',
                        'salary':25000,
                        'commissionPCT':0.90,
                        'managerId':102,
                        'departmentId':5
                     });
            
            expect($scope.updateEmp).toEqual({
                'employeeId':108,
                'firstName':'sid',
                'lastName':'vora',
                'email':'sid@gmail.com',
                'phoneNumber':'9865463255',
                'hireDate':'jhsdag',
                'jobId':'AC_MGR',
                'salary':25000,
                'commissionPCT':0.90,
                'managerId':102,
                'departmentId':5
             });
        }); 

    });

}
);
