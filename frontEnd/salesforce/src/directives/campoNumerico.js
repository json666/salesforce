ª/**
 * Created by JetBrains PhpStorm.
 * User: rloza
 * Date: 12/07/14
 * Time: 21:32
 * Sistema: SCC
 */


app.directive('isNumber', function () {
    return {
        require: 'ngModel',
        link: function (scope) {
            scope.$watch('formData', function(newValue,oldValue) {
//                var arr = String(newValue).split("");
//                if (arr.length === 0) return;
//                if (arr.length === 1 && (arr[0] == '-' || arr[0] === '.' )) return;
//                if (arr.length === 2 && newValue === '-.') return;
//                if (isNaN(newValue)) {
//                    scope.formData = oldValue;
//                }

            });
        }
    };
});



