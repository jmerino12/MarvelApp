# MarvelAPP

Aplicacion movil android
## Tecnologias
- Navigation Components
- View Binding
- Room (Para la persistencia)
- Retrofit
- Hilt


## _Capas_
 Se crearon las siguientes capas:
- Infraestructura: Capa donde se utilizan librerias de 3eros, como Retrofit etc, incluye las implementaciones de lo respositorio, tambien tenemos un paquete de anticorrupcion donde tenemos los traductores. Para convertir los diferentes objetos al objeto dominio pertinente.
- Dominio: En esta capa se crearian las entidades, y es donde iria la logica del negocio.
- Usecases: Capa donde cada accion es representada por medio de un clase, o un llamado caso de uso, aqui se realizan el manejo de los hilos pertinente para dicho caso de uso.
- App: Capa de presentacion, donde va todo lo realciona con la Interfaz grafica.

| Capa | Clases |
| ------ | ------ |
| Dominio | _**CharacterService**_ y _**SerieService**_: Son clases las cuales tiene los comportamientos de nuestra app, en este caso el de realizar la tareas de traer los datos sin importar el origen de estos |
| Infraestructura |  Posee las clases de implementacion de los repositrios y clases proxy ej: _**CharacterProxy**_ y _**CharacterRemoteProxy**_: Son clases encargadas de gestionar el destino de la data ya sea de la base de datos local o desde el webservice.  _**InternetRepository**_ : Clase encargada de verificar la conexion a internet, _**CharacterRetrofitRepository**_ y _**SerieRetrofitRepository**_: Se encargan de traer los datos desde el webservice apuntando a sus respectivos endpoints, _**SerieRoomRepository**_ y _**CharacterRoomRepository**_ : Se encargan de traer los datos desde la base da datos local. _**TheMarvelDb**_ : Configuracion del Retrofit|
| App | _**AndroidCheckedInternet**_: Implementacion de interface(InternetChecker) para verificar la conexion a internet._**UiState**_: Clase sellada para representar los estados de la UI. _**AppModule, DomainModule, InfrastructureModule Y UseCaseModule**_: Son clases para representar cada lo provider para la inyeccion de dependecias.
 





