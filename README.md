<div align="center">
    <img src="https://bambu-mobile.com/wp-content/uploads/2023/10/patrones-de-diseno-de-software-saluciones-aproblemas-de-codigo-2048x1152.jpg" alt="Repository image">
</div>

# Design Patterns en Java

Catálogo didáctico de los 23 patrones de diseño GoF, organizado por intención.

## Categorías

- [Creacionales](src/creationalPatterns/README.md): cómo crear objetos.
- [Estructurales](src/structuralPatterns/README.md): cómo componer objetos y clases.
- [Comportamiento](src/behaviouralPatterns/README.md): cómo distribuir responsabilidades y comunicación.

Cada patrón vive en su propia carpeta y contiene un `README.md` con intención, participantes, trade-offs y cómo ejecutar el ejemplo Java.

## Ejecutar un ejemplo

Desde la raíz, por ejemplo:

```bash
javac src/structuralPatterns/adapter/AdapterExample.java
java -cp src/structuralPatterns/adapter AdapterExample
```

Los ejemplos no dependen de librerías externas y usan una clase pública cuyo nombre coincide con el archivo.

## Convenciones

- Una carpeta representa un patrón.
- `*Example.java` contiene el escenario ejecutable y comentarios breves sobre la colaboración principal.
- La documentación cercana al código es la fuente de contexto del ejemplo.

- [Refactoring Guru](https://refactoring.guru/es/design-patterns)
- [Bambú](https://bambu-mobile.com/que-son-los-patrones-de-diseno-de-software/)