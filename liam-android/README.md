## Liam Android App

Digital Hub to reward kids learning and creativity achievement by allowing them to buy and sell Digital Assets.

### Language
Kotlin

### Architecture
MVVM

### Components used
Android Jetpack  - LiveData, Navigation, ViewModel, Data Binding

### Directory Structure
The directory structure of the app is as follows

- bindings - contains all binding logic particularly for images and input. An example of the image binding logic would be loading an image from the network into an imageView via the Glide library. This is handled in the ImageBindingAdapter.kt
- domain - this is where the data models the app relies on will reside, creating an independent layer to whats sent from the network which is then transformed into what the app requires
- network - This is the network layer and all network classes will reside here
- repository - this is where all the data for the app will originate from. The respective viewModel will make a request and the repository will either query the network or query the database. For the purpose of the Liam app, the data is purely mocked by the repository layer
- ui - all the fragments and viewModels for the different screens reside here

### Screenshots
![device promo](https://github.com/The-Development-Hub/liam-android/blob/master/screenshots/device-2020-03-29-190745.png "Liam: Covid Breaker")
![device promo](https://github.com/The-Development-Hub/liam-android/blob/master/screenshots/device-2020-03-29-191842.png "Liam: Covid Breaker")
![device promo](https://github.com/The-Development-Hub/liam-android/blob/master/screenshots/device-2020-03-29-192014.png "Liam: Covid Breaker")
![device promo](https://github.com/The-Development-Hub/liam-android/blob/master/screenshots/device-2020-03-29-192049.png "Liam: Covid Breaker")
![device promo](https://github.com/The-Development-Hub/liam-android/blob/master/screenshots/device-2020-03-29-192154.png "Liam: Covid Breaker")
