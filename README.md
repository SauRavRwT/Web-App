# WebView Android App

This Android app displays web content using a `WebView`. It loads a specified URL and allows basic navigation within the web content. 

## Features

- Loads web pages inside the app using a `WebView`.
- Supports navigation back and forward within the `WebView`.
- JavaScript is enabled for web pages that require it.
- Handles back press to go to the previous page if possible.

## Download

[Release(beta)](./app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk)

## Requirements

- **Minimum SDK:** 31 (Android 12)
- **Target SDK:** 34
- **Build Tools Version:** 34
- **Language:** Kotlin

## Libraries Used

- [AndroidX AppCompat](https://developer.android.com/jetpack/androidx/releases/appcompat)
- [Material Components for Android](https://material.io/develop/android)
- [WebView](https://developer.android.com/reference/android/webkit/WebView)

## Getting Started

### Prerequisites

You need to have the following installed on your development machine:

- [Android Studio](https://developer.android.com/studio) (latest version recommended)
- [Java 11 or later](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/SauRavRwT/Web-App.git
   cd Web-App
   ```
Open the project in Android Studio.

Build and run the app on an emulator or physical device.

### Usage

- The app loads the URL `Enter_your_link_here` when launched.So, add your link to `MainActivity.kt` and `network_security_config.xml` which is in `app/src/main/res/xml`.

- Use the back button to navigate to the previous web page within the app, or close the app if no more history is available.

### Troubleshooting

Error: `net::ERR_CLEARTEXT_NOT_PERMITTED`
If you're loading an `http://` URL, you may encounter this error. You can fix this by either:

1. Switching to `https://`.
2. Allowing cleartext traffic in your `AndroidManifest.xml` (not recommended for production apps). See the instructions in the code for more details.

### Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.