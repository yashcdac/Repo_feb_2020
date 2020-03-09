	var employeeApp=angular.module("employeeApp",['ui.bootstrap','ngRoute']);
<<<<<<< Upstream, based on branch 'master' of https://github.com/yashcdac/Repo_feb_2020.git

=======
	
>>>>>>> 99833f2 pagination done
	employeeApp.config(function($routeProvider){
		$routeProvider
		.when("/addEmployee",{
			templateUrl:"addEmployee.htm",
			controller:'employeeController'
		})
		.when("/getAllEmployees",{
			templateUrl:"employeeList.htm",
			controller:'employeeController'
		})
		.when("/updateDelEmployee",{
			templateUrl:"updateDelList.htm",
			controller:'employeeController'
		})
		.when("/updateEmployee",{
			templateUrl:"updateEmp.htm",
			controller:'employeeController'
		})
		.when('/getEmployeeById',{
			templateUrl:'empId.htm',
			controller:'employeeController'
		})
		;
	})
	
	employeeApp.controller('employeeController',['$rootScope','$scope','$http','$log','$location',function($rootScope,$scope,$http,$log,$location){
		$scope.filteredEmployees = []
	      ,$scope.currentPage = 1
	      ,$scope.numPerPage = 10
	      ,$scope.maxSize = 5;
	      
	      $scope.getAllEmployee=()=>{
				$http({url:"employee?action=getAllEmployee"})
				.then(function(response){
					$scope.employees=response.data;
				
				},
				function(response){
						$log.error(response);
					}
			
			)};
			 
			 $scope.$watch('currentPage + numPerPage', function() {
		    	 console.log('$watch')
		        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
		        , end = begin + $scope.numPerPage;
		        
		    	 $scope.filteredEmployees = $scope.employees.slice(begin, end);
		        
		        console.log($scope.filteredEmployees);
		      });
			 
		$scope.addEmployee=(e,d,j,m)=>{
			console.log(e)
			e.departmentId=d;
			e.jobId=j;
			e.managerId=m;
			console.log(e)
			 $http({
					url:'employee?action=addEmployee',
					method:'POST',
					data:{
						'employeeId':e.employeeId,
						'firstName':e.firstName,
						'lastName':e.lastName,
						'email':e.email,
						'phoneNumber':e.phoneNumber,
						'hireDate':e.hireDate,
						'jobId':e.jobId,
						'salary':e.salary,
						'commissionPCT':e.commissionPCT,
						'managerId':e.managerId,
						'departmentId':e.departmentId,
					}})
			.then(
			res=>{
				$scope.status=res.data;
			},
			err=>{
				$log.error(err);
			}
			); 
		}
		
	
		$http({url:"employee?action=getAllDepartment"})
		.then(function(response){
			$scope.deptList=response.data;
			console.log($scope.deptList)
		},
	function(response){
			$log.error(response);
		}
	
	);
		$http({url:"employee?action=getAllJobs"})
		.then(function(response){
			$scope.jobList=response.data;
			console.log($scope.jobList)
		},
	function(response){
			$log.error(response);
		}
	
	);
		$http({url:"employee?action=getAllManagers"})
		.then(function(response){
			$scope.managerList=response.data;
			console.log($scope.managerList)
		},
	function(response){
			$log.error(response);
		}
	
	);
		
		
		$scope.getId=(e)=>{
			// console.log(e)
			// console.log($scope.id)
			if(e!=null){
				$http({
					url:'employee?action=getEmployeeById&employeeId='+e,
					method:'GET'
					})
				.then(function(response)
						{
							$scope.searchEmployee=response.data;
							console.log(response);
						},
					  function(response)
					  {
							$log.error(response);
					  }
					 )
			}
			
		}
		
		
		$scope.deleteEmp=function(e)
		{
			console.log(e);
			$http({url:"employee?action=deleteEmployee",
				method:'POST',
				data: {
				 	'employeeId':e
				 	}
			})
			.then(function(response){
				console.log(response.data);
				$scope.message=response.data;
			},
		function(response){
				$log.error(response);
			}
			);
			
			
		}
		$scope.getUpdateEmployee=(employee)=>{
			console.log('getUpdateEmployee');
			
			$rootScope.updateEmp=employee;
			
			$location.path('updateEmployee');
		};
		
		$scope.updateEmployee=function(e){
			console.log('updateEmployee');
			$http({
				url:'employee?action=updateEmployee',
				method:'POST',
				 data: {
					 	'employeeId':e.employeeId,
						'firstName':e.firstName,
						'lastName':e.lastName,
						'email':e.email,
						'phoneNumber':e.phoneNumber,
						'hireDate':e.hireDate,
						'jobId':e.jobId,
						'salary':e.salary,
						'commissionPCT':e.commissionPCT,
						'managerId':e.managerId,
						'departmentId':e.departmentId
					 }
			}).then((res)=>{
				console.log(res.data);
				$rootScope.message=res.data;
			},(err)=>{
				$log.error(err);
			});
		};
		
	}]);