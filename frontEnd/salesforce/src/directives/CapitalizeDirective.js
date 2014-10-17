app.directive('capitalizeLowerCase', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, modelCtrl) {
            var capitalizeLowerCase = function (inputValue) {
                if (inputValue != undefined) {
                    var capitalizeLowerCased = inputValue.toLowerCase();
                    if (capitalizeLowerCased !== inputValue) {
                        modelCtrl.$setViewValue(capitalizeLowerCased);
                        modelCtrl.$render();
                    }
                    return capitalizeLowerCased;
                }
            }
            modelCtrl.$parsers.push(capitalizeLowerCase);
            capitalizeLowerCase(scope[attrs.ngModel]);  // capitalizeLowerCase initial value
        }
    };
});
app.directive('capitalize', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, modelCtrl) {
            var capitalize = function (inputValue) {
                if (inputValue != undefined) {
                    var capitalized = inputValue.toUpperCase();
                    element.css('text-transform', 'uppercase');
                    if (capitalized !== inputValue) {
                        modelCtrl.$setViewValue(capitalized);
                    }
                    return capitalized;
                }
            }
            modelCtrl.$parsers.push(capitalize);
            capitalize(scope[attrs.ngModel]);  // capitalize initial value
        }
    };
});