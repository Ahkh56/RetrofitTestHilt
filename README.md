# ⚡️ Retrofit Test Hilt

This is a sample Android application built to demonstrate modern Android development practices, including a multi-module clean architecture, Jetpack Compose, Hilt for dependency injection, and Retrofit for networking.

## ✨ Features

- **Splash Screen**: A branded launch screen.
- **Welcome Screen**: A simple introductory screen.
- **Product Grid**: Fetches a list of products from a fake store API and displays them in a grid.

## 🏛️ Architecture

The project follows the principles of Clean Architecture, separating concerns into different layers and modules.

- **UI**: Built entirely with **Jetpack Compose** using a ViewModel/UI State pattern.
- **Dependency Injection**: **Hilt** is used to manage dependencies throughout the app.
- **Networking**: **Retrofit** and **Gson** are used for making network calls and parsing JSON.
- **Asynchronous Programming**: **Kotlin Coroutines** and **Flow** are used to manage background threads and handle asynchronous data streams.
- **Image Loading**: **Coil** is used for loading and displaying images from URLs.
- **Navigation**: **Jetpack Navigation for Compose** is used to handle navigation between screens.

## 🚀 Modules

The project is divided into several modules to enforce separation of concerns:

- **`:app`**: The main application module. It ties together all the feature modules and provides the main `Activity` and navigation graph.
- **`:core`**: A common library module containing shared code such as utility classes, base UI components, navigation route definitions (`Screen.kt`), and the `Resource` wrapper.
- **`:data`**: Implements the data layer. It contains repository implementations, the Retrofit `ApiService`, and Hilt modules for providing data-related dependencies.
- **`:domain`**: Contains the core business logic of the application. This includes data models, repository interfaces, and use cases.
- **`:feature-welcome`**: A self-contained feature module for the splash and welcome screens.
- **`:feature-home`**: A self-contained feature module for the home screen, responsible for displaying the list of products.

## 💡 Tech Stack

| Category                 | Technology                                       |
| ------------------------ | ------------------------------------------------ |
| **Language**             | Kotlin                                           |
| **UI Toolkit**           | Jetpack Compose                                  |
| **Architecture**         | MVVM + Clean Architecture (Multi-Module)         |
| **Dependency Injection** | Hilt                                             |
| **Asynchronous**         | Kotlin Coroutines + Flow                         |
| **Networking**           | Retrofit + Gson                                  |
| **Image Loading**        | Coil                                             |
| **Navigation**           | Jetpack Navigation-Compose                       |

## 🧩 Setup Instructions

**1️⃣ Clone the repository**
```bash
git clone https://github.com/yourusername/RetrofitTestHilt.git
cd RetrofitTestHilt
```

**2️⃣ Open in Android Studio**
- Use Android Studio Hedgehog or a more recent version.

**3️⃣ Build the project**
- The project should sync and build automatically. If not, run the following command:
```bash
./gradlew assembleDebug
```

## Key Implementation Details

**🧠 Asynchronous State Management**

The app uses a `Resource<T>` wrapper class (`core` module) to represent UI state for network operations. The `GetProductsUseCase` returns a `Flow<Resource<List<Product>>>` that emits `Loading`, `Success`, or `Error` states, which the `HomeViewModel` collects to update the Compose UI reactively.

**🌐 Repository Pattern**

The `domain` layer defines the `ProductRepository` interface, abstracting the data source from the business logic. The `data` layer provides the concrete implementation (`ProductRepositoryImpl`) which uses Retrofit to fetch data from the remote API.

**🧭 Multi-Module Navigation**

To prevent circular dependencies, navigation routes are defined in a `Screen.kt` sealed class within the `:core` module. The main navigation graph in the `:app` module and all feature modules reference this single source of truth for type-safe navigation.

## 🧭 Roadmap

- [ ] Add a Product Detail Screen.
- [ ] Implement robust error handling with a "Retry" option.
- [ ] Add Unit Tests for ViewModels, Use Cases, and Repositories.
- [ ] Implement caching with Room to support offline mode.

## 🪪 License

Copyright (c) 2025 [Abdul Hanan Khan]

Licensed under the MIT License. You may use, copy, modify, and distribute this software for any purpose, provided that the above copyright notice and this permission notice are included in all copies or substantial portions of the Software.

## 💬 Contact

- **Author**: [Abdul Hanan Khan]
- **Email**: [ahkhan622@gmail.com]
- **GitHub**: @Ahkh56
