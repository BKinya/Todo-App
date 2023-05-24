# Todo-App
A Todo app: A sample app to use at Pwani workshops, May Edition: Building Android UI with Jetpack Compose

## Demo

https://github.com/BKinya/Todo-App/assets/30239692/519bb338-2d9f-40ac-895f-3651aeaf97c8



## Session 01: Compose Layouts

### Compose Layouts
- Column: used to arrange ui elements vertically.
- Row: used to arrange ui elements horizontally.
- Box: ui elements are stacked on top of each other

### Modifiers
- Modifiers are used to tweak appearance and behaviour of composables.

### Resources
- [Getting Started: Jetpack Compose Layouts | Slides](https://speakerdeck.com/bkinya/getting-started-jetpack-compose-layouts)
- [Layouts in Compose| Docs](https://developer.android.com/jetpack/compose/layouts/basics)
- [Lists and Grids](https://developer.android.com/jetpack/compose/lists)
- [Deep dive into Jetpack Compose Layouts](https://www.youtube.com/watch?v=zMKMwh9gZuI&list=PLWz5rJ2EKKc9Ty3Zl1hvMVUsXfkn93NRk&index=28)

## Session 02 : Mastering State in Compose

State in an app is any value that can change, like whether to show a button or not, the result of fetching data from a data source, and much more. In this session, we'll learn about state and composition. We'll look at smart recomposition,   stable and unstable state and how state stability affects recomposition.  We'll also learn about at state hoisting and create stateful and stateless composable. 


### Resources
- [Handling State in Compose | Slides](https://speakerdeck.com/bkinya/handling-state-in-jetpack-compose)
- [Jetpack Compose Stability Explained](https://medium.com/androiddevelopers/jetpack-compose-stability-explained-79c10db270c8)
- [Jetpack Compose Debbuging](https://io.google/2023/program/a3ed5302-d787-41bd-8623-54193d36caf0/)
- [Managing State in Jetpack Compose](https://www.kodeco.com/30172122-managing-state-in-jetpack-compose)
- [State in Jetpack Compose](https://www.youtube.com/watch?v=PMMY23F0CFg&list=PLWz5rJ2EKKc9Ty3Zl1hvMVUsXfkn93NRk&index=22)


## Session 03: Architecting Your Compose UI, A Deep Dive
Compose is declarative. In compose the UI is immutable. You cannot update it once it has been drawn. When the state changes, Compose recreates
parts of the UI that have changed.

Composable functions can accept state and expose events. The events update state. Hence, a Unidirectional Data Flow(UDF) pattern is appropriate
when using Jetpack Compose.

In UDF, data flows down while events flow up. This enables separating composables that display state in the UI from part of code that store and change state.

In this project, I have used an MVI approach, sealed interfaces to create exhaustive UI states, and `SharedFlow` to create a stream of events.

### Resources
- [Architecting Compose UI, A Deep Dive | Slides ](https://speakerdeck.com/bkinya/architecting-compose-ui-a-deep-dive)
- [Architecture in Jetpack Compose | Blog](https://medium.com/mobile-at-octopus-energy/architecture-in-jetpack-compose-mvp-mvvm-mvi-17d8170a13fd)
- [SharedFlow,BroadCast Channels | Blog](https://elizarov.medium.com/shared-flows-broadcast-channels-899b675e805c)
- [Clean Android Multi-Module Offline-First Scalable App in 2022 | Blog](https://www.droidcon.com/2022/08/16/clean-android-multi-module-offline-first-scalable-app-in-2022-including-jetpack-compose-mvi-kotlin-coroutines-flow-kotlin-serialization-hilt-and-room/)


## Session 04: Navigation in Jetpack Compose

### Resources
- [Navigating With Compose | Docs](https://developer.android.com/jetpack/compose/navigation)
- [Navigating in Compose | Blog](https://medium.com/google-developer-experts/navigating-in-jetpack-compose-78c78d365c6a)

Happy Composing! 🎉


Find Me 👇🏼

[Twitter](https://twitter.com/B__Kinya) || [LinkedIn](https://www.linkedin.com/in/beatrice-kinya-93307514b/) || [Hashnode](https://kinya.hashnode.dev)
