workspace "Plataforma de Cotización de Seguros" {
    description "Sistema que permite a los clientes cotizar pólizas en línea, integrado al core SISE de la aseguradora."

    model {
        // Personas
        cliente = person "Cliente" {
            description "Persona interesada en cotizar pólizas de seguros"
            tags "Actor"
        }

        // Sistema externo
        sise = softwareSystem "SISE - Sistema Core de Seguros" {
            description "Sistema central de la aseguradora para gestionar pólizas y clientes"
            tags "SistemaExterno"
        }

        // Sistema principal
        cotizador = softwareSystem "Cotizador de Seguros" {
            description "Sistema que permite cotizar productos de seguros de forma online"
            tags "SistemaCotizador"

            apiWeb = container "API Web - Cotizador" {
                technology "Java + Spring Boot"
                description "Expone servicios REST para cotizar pólizas"
                tags "Api"

                cliente -> this "Solicita cotización" "HTTPS"
                this -> sise "Consulta tarifas y condiciones" "REST/JSON"

                // Componentes
                cotizacionController = component "CotizacionController" {
                    description "Controlador REST para recibir las solicitudes de cotización"
                    technology "Spring REST Controller"
                    tags "Componente"
                }

                cotizacionService = component "CotizacionService" {
                    description "Lógica de negocio para calcular cotizaciones"
                    technology "Servicio Spring"
                    tags "Componente"
                }

                cotizacionRepository = component "CotizacionRepository" {
                    description "Accede a la base de datos de cotizaciones"
                    technology "Spring Data JPA"
                    tags "Componente"
                }

                cotizacionController -> cotizacionService "Delegación de lógica de negocio"
                cotizacionService -> cotizacionRepository "Acceso a datos de cotización"
            }

            baseDatos = container "Base de Datos" {
                technology "PostgreSQL"
                description "Almacena cotizaciones, clientes y productos"
                tags "Database"

                apiWeb -> this "CRUD de cotizaciones"
            }
        }
    }

    views {
        // Vista de contexto
        systemContext cotizador {
            include *
            autolayout lr
            title "Vista de contexto del sistema Cotizador de Seguros"
        }

        // Vista de contenedores
        container cotizador {
            include *
            autolayout lr
            title "Vista de contenedores del Cotizador de Seguros"
        }

        // Vista de componentes (clave válida)
        component apiWeb componentes_api_web {
            include *
            autolayout lr
            title "Vista de componentes del API Web"
        }

        styles {
            element "Actor" {
                shape Person
                background #ffcc00
                color #000000
            }

            element "SistemaCotizador" {
                shape RoundedBox
                background #28a745
                color #ffffff
            }

            element "SistemaExterno" {
                shape Box
                background #cccccc
                color #000000
                border dashed
            }

            element "Api" {
                shape Hexagon
                background #007bff
                color #ffffff
            }

            element "Database" {
                shape Cylinder
                background #6c757d
                color #ffffff
            }

            element "Componente" {
                shape Component
                background #17a2b8
                color #ffffff
            }
        }
    }
}