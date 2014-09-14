/**
 * User: esalamanca
 * Date: 07-01-14
 * Time: 02:28 PM
 * Directiva para validar Items.
 */

app.directive('miValidacionItem', function() {

    //Funcion LINK que realiza la validacion
    function link2(scope, elem, attrs) {

        var $form2 = $("#dueItemNueva");
        var validator2 = $form2.validate({
            rules: {
                subpartida: {
                    required: true,
                    maxlength: 10,
                    minlength: 9,
                    digits: true
                },
                codigoComplementario: {
                    required: true,
                    maxlength: 4,
                    minlength: 4,
                    digits: true
                },
                codigoSuplementario: {
                    required: true,
                    maxlength: 4,
                    minlength: 4,
                    digits: true
                },
                declaracionPrecedente: {
                    maxlength: 20,
                    minlength: 10
                },
                itemPrecedente: {
                    number: true,
                    maxlength: 5,
                    digits: true
                },
                cantidad: {
                    number: true,
                    min: 0.01,
                    max: 99999.99,
                    required: true
                },
                embalaje: {
                    required: true
                },
                pesoBruto: {
                    number: true,
                    min: 0.001,
                    max: 999999999999999.999,
                    required: true
                },
                pesoNeto: {
                    number: true,
                    min: 0.001,
                    max: 999999999999999.999,
                    required: true
                },
                cantidadSubpartida: {
                    number: true,
                    min: 0.001,
                    max: 999999999999999.999,
                    required: true
                },
                dscMercancia: {
                    maxlength: 1000,
                    required: true
                },
                paisOrigen: {
                    required: true
                },
                condicion: {
                    required: true
                },
                lugarEntrega: {
                    maxlength: 40,
                    required: true
                },
                valorFactura: {
                    number: true,
                    min: 0.001,
                    max: 9999999999.999,
                    required: true
                },
                valorMoneda: {
                    required: true
                },
                formaPago: {
                    required: true
                },
                valorFOB: {
                    number: true,
                    min: 0.001,
                    max: 9999999999.999,
                    required: false
                },
                valorTransaccion: {
                    number: true,
                    min: 0.001,
                    max: 9999999999.999,
                    required: true
                },
                obsItem: {
                    maxlength: 1000
                }
            },
            highlight: function (element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            unhighlight: function (element) {
                $(element).closest('.form-group').removeClass('has-error');
            },
            errorElement: 'span',
            errorClass: 'help-block',
            errorPlacement: function (error, element) {
                if (element.parent('.input-group').length) {
                    error.insertAfter(element.parent());
                } else {
                    error.insertAfter(element);
                }
            }
        });

        //Validar todos los campos despues de focus out
        $form2.find(":input").bind("focusout", function(e) {
            $(this).valid();
        });
    }

    return {
        restrict: 'E',
        link: link2
    }
});