# MeliSearch

Esta app tiene como objetivo realizar búsquedas de productos y ver los detalles, tomando como modelo las búsquedas en la pagina de Mercado Libre.

Se intentó recrear a grandes rasgos el comportamiento y apariencia que normalmente se accede en la plataforma de búsquedas de Meli, conectándonos al API REST de desarrollo, para acceder a los
endpoints y realizar consultas específicas en tiempo real.

Generando búsquedas por país sobre productos ya sea por Nombre y/o Categoria, asi mismo se incluyo un Historial de publicaciones vistas.

La App permite:

1. Realizar busquedas por medio de un campo de búsqueda.
2. Visualización de resultados de la búsqueda.
3. Visualizar el detalle de un producto seleccionado.

## MVVM

Para la estructuración y organizacion de los elementos de presentacion de las vistas se hizo uso del patron de presentacion MVVM. suscribiendose a los cambios de los datos del modelo hacia la vista
mediante los LiveData, una clase observable optimizada para ciclos de vida como actividades, fragmentos o servicios. Que garantiza que solo se actualice la informacion a los componentes que su estado
de ciclo de vida este activo.

## DataBinding

Permite la vinculación de datos de los componentes de la IU de de los diseños de datos, mejorar el rendimiento de la app y ayudar a evitar pérdidas de memoria y excepciones de puntero nulo.
