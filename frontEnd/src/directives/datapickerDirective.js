/**
 * Created by rloza on 21/01/14.
 */
app.directive('datepicker', function() {
    return {
        require: 'ngModel',
        link: function(scope, el, attr, ngModel) {
            $(el).datepicker({
                onSelect: function(dateText) {
                    scope.$apply(function() {
                        ngModel.$setViewValue(dateText);
                    });
                }
            });

            $(function(el){
                $.datepicker.regional['es'] = {
                    closeText: 'Cerrar',
                    prevText: '<Ant',
                    nextText: 'Sig>',
                    currentText: 'Hoy',
                    monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                    monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
                    dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
                    dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
                    dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
                    weekHeader: 'Sm',
                    dateFormat: 'dd-mm-yy',
                    firstDay: 1,
                    isRTL: false,
                    showMonthAfterYear: false,
                    changeYear: true,
                    changeMonth: true,
                    minDate: new Date(1900,1-1,1), maxDate: '-18Y',
                    defaultDate: new Date(1996,1-1,1),
                    yearRange: '-110:-18',
                    yearSuffix: ''

                };
                $.datepicker.setDefaults($.datepicker.regional['es']);
            });
        }
    };


});


//    $(function() {
//        $("#fechanac").datepicker(
//            {
//                minDate: new Date(1900,1-1,1), maxDate: '-18Y',
//                dateFormat: 'dd/mm/yy',
//                defaultDate: new Date(1996,1-1,1),
//                changeMonth: true,
//                changeYear: true,
//                yearRange: '-110:-18'
//            }
//        );
//    });


