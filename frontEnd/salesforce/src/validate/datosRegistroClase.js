/**
 * Created by osanchez on 17/10/14.
 */
app.directive('datosRegistroClase', function () {

    //Funcion LINK que realiza la validacion
    function link(scope, element, attrs) {
        console.log('Directiva DATOS CLASE');
        //Formulario que deseamos validar (lo agarramos como objeto jQuery)
        var $form = $("#claseForm");

        var validateMethod = $.fn.validate;
        $.fn.validate = function (o) {
            if (o && o.rules) {
                for (var name in o.rules) {
                    var rule = o.rules[name];
                    if ((rule.required != undefined) || (rule.requerido != undefined)) {
                        if (rule.required === true) {
                            var inputId = $('[name="' + name + '"]').attr("id");
                            var label = $('label[for=' + inputId + ']');
                            var nameFinal = name;
                            nameFinal = nameFinal.replace(/\./g, '_');
                            if ($("#requiredSpan" + nameFinal).length <= 0) {
                                label.before("<span id=\"requiredSpan" + nameFinal + "\" class=\"red bolder\">*</span> ");
                            }
                        }
                        else {
                            var inputId = $('[name="' + name + '"]').attr("id");
                            var label = $('label[for=' + inputId + ']');
                            var nameFinal = name;
                            nameFinal = nameFinal.replace(/\./g, '_');
                            if ($("#requiredSpan" + nameFinal).length <= 0) {
                                label.before("<span id=\"requiredSpan" + nameFinal + "\" class=\"green bolder\">*</span> ");
                            }
                        }
                    }
                }
            }
            return $.proxy(validateMethod, this)(o);
        };
        /**
         * Definimos las reglas de validacion del formulario
         */
        $form.validate({
            rules: {
                "descripcionClase": {
                    required: true
                },
                "fechaDesde": {
                    required: true
                },
                "fechaHasta": {
                    required: true
                },
                "categoria":{
                    required: true
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
        $form.find(":input").bind("focusout", function (e) {
            $(this).valid();
        });
    }

    return {
        restrict: 'E',
        link: link
    };
});
