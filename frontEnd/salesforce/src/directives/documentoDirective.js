/**
 * User: esalamanca
 * Date: 07-01-14
 * Time: 02:28 PM
 * Directiva para validar Documentos adicionales.
 */

app.directive('miValidacionDocumento', function() {

    //Funcion LINK que realiza la validacion
    function link3(scope, elem, attrs) {

        var $form3 = $("#dueDocumentoNuevo");
        var validator3 = $form3.validate({
            rules: {
                tipoDocumento: {
                    required: true
                },
                numero: {
                    maxlength: 30,
                    required: true
                },
                emisor: {
                    maxlength: 50,
                    required: true
                },
                fechaExpedicion: {
                    date: true,
                    required: true
                },
                fechaVencimiento: {
                    date: true,
                    required: false
                },
                moneda: {
                    required: false
                },
                monto: {
                    number: true,
                    min: 0.001,
                    max: 9999999999.999,
                    required: false
                },
                unidad: {
                    required: false
                },
                cantidad: {
                    number: true,
                    min: 0.001,
                    max: 999999999999999.999,
                    required: false
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
        $form3.find(":input").bind("focusout", function(e) {
            $(this).valid();
        });
    }

    return {
        restrict: 'E',
        link: link3
    }
});