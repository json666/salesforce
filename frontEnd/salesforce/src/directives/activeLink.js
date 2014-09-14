/**
 * Created by JetBrains PhpStorm.
 * User: rloza
 * Date: 10/08/14
 * Time: 17:30
 * Sistema: SCC
 */

app.directive('isActiveNav', [ '$location', function($location) {
    return {
        restrict: 'A',
        link: function(scope, element) {
            scope.location = $location;
            scope.$watch('location.path()', function(currentPath) {
                if('/#' + currentPath === element[0].attributes['href'].nodeValue) {
                    element.parent().addClass('active');
                } else {
                    element.parent().removeClass('active');
                }
            });
        }
    };
}]);
