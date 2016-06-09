FootballFoursApp.controller('userController', function($scope, $http) {

    $scope.login = function() {
        $http.post("login", $scope.newUser, httpConfig).success(
                function(response) {
                    $scope.user = response.user;
                });
    }

    $scope.logout = function() {
        $http.get("logout", httpConfig).success(function(response) {
            $scope.user = response.user;
        });
    }
});