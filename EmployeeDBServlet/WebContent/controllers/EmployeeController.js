	var employeeApp=angular.module("employeeApp",['ui.bootstrap','ngRoute','zingchart-angularjs']);

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
		.when("/getAllJobs",{
			templateUrl:"jobList.htm",
			controller:'employeeController'
		})
		.when("/getJobById",{
			templateUrl:"GetJobByID.htm",
			controller:'employeeController'
		})
		.when("/updateDelJob",{
			templateUrl:"updateDelJob.htm",
			controller:'employeeController'
		})
		.when("/updateJob",{
			templateUrl:"updateJob.htm",
			controller:'employeeController'
		})
		.when("/addJob",{
			templateUrl:"createJob.htm",
			controller:'employeeController'
		})
		.when("/getAllDepartments",{
			templateUrl:"departmentList.htm",
			controller:'employeeController'
		})
		.when("/getDepartmentById",{
			templateUrl:"getDepartmentById.htm",
			controller:'employeeController'
		})
		.when("/updateDelDepartment",{
			templateUrl:"updateDelDepartment.htm",
			controller:'employeeController'
		})
		.when("/updateDept",{
			templateUrl:"updateDepartment.htm",
			controller:'employeeController'
		})
		.when("/addDepartment",{
			templateUrl:"createDepartment.htm",
			controller:'employeeController'
		})
		.when("/chart",{
			templateUrl:"chart.htm",
			controller:'employeeController'
		})
		.when('/login',{
			templateUrl:'login.htm',
			controller:'employeeController'
		})
		.when('/logout',{
			templateUrl:'login.htm',
			controller:'employeeController'
		})
		.otherwise({ redirectTo: '/' })
		
	})
	

	
	employeeApp.controller('employeeController',['$rootScope','$scope','$http','$log','$location',function($rootScope,$scope,$http,$log,$location){
		$scope.filteredEmployees = []
	      ,$scope.currentPage = 1
	      ,$scope.numPerPage = 10
	      ,$scope.maxSize = 5;
		$rootScope.flag=true;
		$scope.login=function(e){
			$http({url:"employee?action=login",
				method:'POST',
				data:{
				 	'username':e.username,
				 	'password':e.password
				 	}
			})
			.then(function(response){
				var role=response.data[0];
				console.log(role.role)
				if(role.role =='admin')
				{
					$rootScope.flag=false;
				$location.path('index');
				}else{
					$scope.msg="invalid credentials";
				}
			},
			function(response){
					$log.error(response);
				})
		};

		
		$scope.myJson = {
                type: "pie3d",
                labels:[],
                title: {
                  fontColor: "#8e99a9",
                  text: 'Department wise team size',
                  align: "left",
                  offsetX: 10,
                  fontFamily: "Open Sans",
                  fontSize: 25
                },
                subtitle: {
                  offsetX: 10,
                  offsetY: 10,
                  fontColor: "#8e99a9",
                  fontFamily: "Open Sans",
                  fontSize: "16",
                  text: 'March 2020',
                  align: "left"
                },
                plotarea: {
                  margin: "20 0 0 0"  
                 },
                series : [    ]
          };
   $scope.getDepartmentMap=()=>{
          
          let departmentMap=new Map();
          let departmentData=$scope.deptList;
          for(dep of departmentData){
                console.log(dep);
                if(!departmentMap.has(dep.departmentId)){
                       departmentMap.set(dep.departmentId,dep.departmentName);
                }
          }
          return departmentMap; 
   }
   $scope.getDepartmentwiseHeads=()=>{
          let depMap=$scope.getDepartmentMap();
          let departmentWiseHeads=new Map();
          let employeeData=$scope.employees;
          for(emp of employeeData){
//              console.log(emp);
                let depName=depMap.get(emp.departmentId);
                console.log(depName);
                if(!departmentWiseHeads.has(depName)){
                       departmentWiseHeads.set(depName,1);
                }else{
                       let count=departmentWiseHeads.get(depName);
                       count++;
                       departmentWiseHeads.set(depName,count);
                }
          }
          
          for (let [key, value] of departmentWiseHeads.entries()) {
                console.log(key);
                let graphData={
                             'font-size': "20",
                             x: "60%",
                             y: "20%"
                           };
                $scope.myJson.labels.push(graphData);
                $scope.myJson.series.push({
                       values : [value],
                       text:key
                });
                
          }
         
   }
   
		
		$http({url:"department?action=getAllDepartments"})
		.then(function(response){
			console.log(response.data)
			$scope.departmentList=response.data;
		
		},
		function(response){
				$log.error(response);
			}
	
		)
			 $scope.$watch('currentPage + numPerPage', function() {
		    	 console.log('$watch for jobs')
		        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
		        , end = begin + $scope.numPerPage;
		        
		    	 $scope.filteredDepartments = $scope.departmentList.slice(begin, end);
		        
		        console.log($scope.filteredDepartments);
		      });
		
		
		$scope.getDepartmentById=(departmentId)=>{
			if(departmentId!=null){
				$http({
					url:'department?action=getDepartmentById&departmentId='+departmentId,
					method:'GET'
					})
				.then(function(response)
						{
							$scope.searchDept=response.data;
							console.log(response);
						},
					  function(response)
					  {
							$log.error(response);
					  }
					 )
			}
		}
		
		$scope.addDeptFlag=false;
		
		$scope.openDeptForm=()=>{
			$scope.addDeptFlag=true;
		}
		$scope.addDepartment=(department)=>{
			console.log(department)
			
			 $http({
					url:'department?action=addDepartment',
					method:'POST',
					data:{
						'departmentId':department.departmentId,
						'departmentName':department.departmentName,
						'managerId':department.managerId,
						'locationId':department.locationId
						
					
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
		
		
		
		$scope.updateDepartment=(department)=>{
			
			console.log(department);
			
			$rootScope.updateD=department;
			console.log($rootScope.updateD);
			$location.path('updateDept');
		}

		$scope.DepartmentUpdate=()=>{
			console.log('after updat');
			
			$http({
				url:'department?action=updateDepartment',
				method:'POST',
				 data: {
					 'departmentId':$rootScope.updateD.departmentId,
					 'departmentName':$rootScope.updateD.departmentName,
					 'managerID':$rootScope.updateD.managerID,
					 'locationId':$rootScope.updateD.locationId

						
					 }
			}).then((res)=>{
				console.log(res.data);
				$rootScope.message=res.data;
			},(err)=>{
				$log.error(err);
			});
			
		}
		$scope.deleteDepartment=(id)=>{
			console.log(id)
			$http({url:"department?action=deleteDepartment",
				method:'POST',
				data: {
				 	'departmentId':id
				 	}
			})
			.then(function(response){
				console.log(response.data);
				$scope.message=response.data;
				alert("Deleted with id "+id)
			},
			function(response){
				$log.error(response);
			}
			);
		}
		
		
		
		
		
		
		
		
		$scope.updateJob=(job)=>{
			
			console.log(job);
			
			$rootScope.updateJ=job;
			console.log($scope.updateJ);
			$location.path('updateJob');
		}
		$scope.JobUpdate=()=>{
			console.log('after updat');
			
			$http({
				url:'job?action=updateJob',
				method:'POST',
				 data: {
					 'jobId':$rootScope.updateJ.jobId,
						'jobTitle':$rootScope.updateJ.jobTitle,
						'minSalary':$rootScope.updateJ.minSalary,
						'maxSalary':$rootScope.updateJ.maxSalary
					 }
			}).then((res)=>{
				console.log(res.data);
				$rootScope.message=res.data;
			},(err)=>{
				$log.error(err);
			});
			
		}
		$scope.deleteJob=(jobId)=>{
			console.log(jobId)
			$http({url:"job?action=deleteJob",
				method:'POST',
				data: {
				 	'jobId':jobId
				 	}
			})
			.then(function(response){
				console.log(response.data);
				$scope.message=response.data;
				alert("Deleted with id "+jobId)
			},
			function(response){
				$log.error(response);
			}
			);
		}
		
		$scope.getJobById=(jobId)=>{
			if(jobId!=null){
				$http({
					url:'job?action=getJobById&jobId='+jobId,
					method:'GET'
					})
				.then(function(response)
						{
							$scope.searchJob=response.data;
							console.log(response);
						},
					  function(response)
					  {
							$log.error(response);
					  }
					 )
			}
		}
		$scope.addFlag=false;
		
		$scope.openForm=()=>{
			$scope.addFlag=true;
		}
		
		$scope.addJob=(job)=>{
			console.log(job)
			
			 $http({
					url:'job?action=addJob',
					method:'POST',
					data:{
						'jobId':job.jobId,
						'jobTitle':job.jobTitle,
						'minSalary':job.minSalary,
						'maxSalary':job.maxSalary
					
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
		
		$http({url:"job?action=getAllJobs"})
		.then(function(response){
			$scope.jobs=response.data;
		
		},
		function(response){
				$log.error(response);
			}
	
		)
			 $scope.$watch('currentPage + numPerPage', function() {
		    	 console.log('$watch for jobs')
		        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
		        , end = begin + $scope.numPerPage;
		        
		    	 $scope.filteredJobs = $scope.jobs.slice(begin, end);
		        
		        console.log($scope.filteredJobs);
		      });
	      
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
				alert("employee deleted with id = "+e)
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