# idealistaTest
Implementación de la prueba técnica para idealista: cálculo de puntuaciones de anuncios con Java

Se han tenido en cuenta los siguientes **requisitos**:

1. Yo como encargado de calidad quiero asignar una puntuación a un anuncio para que los usuarios puedan ordenar anuncios de mejor a peor 
*Nota: La puntuación de un anuncio es un valor entre 0 y 100 y se calcula siguiendo las siguientes reglas:*
  - Que el anuncio no tenga ninguna foto resta 10 puntos
  - Cada foto que tenga el anuncio proporciona 20 puntos si es una foto HD o 10 si no lo es
  - Que tenga descripción aporta 5 puntos
  - El tamaño de la descripción también proporciona puntos cuando el anuncio es sobre un piso o sobre un chalet. En el caso de las casas aporta 10 puntos si la descripción tiene 20 o mas palabras y 30 puntos si tiene 50 o mas palabras. En el caso de los chalets, si tiene mas de 50 palabras, añade 20 puntos.
  - Que las siguientes palabras aparezcan en la descripción añaden 5 puntos cada una: Luminoso, Nuevo, Céntrico, Reformado, Ático
  - Que el anuncio esté completo también aporta puntos. Para considerar un anuncio completo este tiene que tener descripción, al menos una foto y los datos particulares de cada tipología, esto es, en el caso de los pisos tiene que tener
también tamaño de vivienda, en el de los chalets, tamaño de vivienda y de jardín. Además, excepcionalmente, en los garajes no es necesario que el anuncio tenga descripción. Si el anuncio tiene todos los datos anteriores, proporciona otros 40
puntos.
2. Yo como encargado de calidad quiero que los usuarios no vean anuncios irrelevantes para que el usuario siempre vea contenido de calidad en idealista Nota: Un anuncio se considera irrelevante si tiene una puntuación menor a 40
3. Yo como encargado de calidad quiero poder ver los anuncios irrelevantes y desde que fecha lo son para medir la calidad media del contenido del portal
4. Yo como usuario de idealista quiero poder ver los anuncios ordenados de mejor a peor para encontrar fácilmente mi vivienda

El ejecutable se encuentra en **realeses**, y para ejecutarlo solo es necesario:
```
java -jar idealistaTest.jar adds.json photos.json
```
