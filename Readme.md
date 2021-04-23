# NV's Book store
# Intsallation process
User can use virtual or physical device to install the project.
Download zip file and extract it to your project folder or clone application to android studio.

# OVERVIEW of NV's Book Store
* Online bookstore is a web application which enables the customer to buy books online. There is browser through which customers can search for a book in the catalogue by it's title or author or even cost. The book of choice can then be added to the shopping cart which can contain as many books as the customer wants to purchase. There is also an option to give ratings for the book of choice after the purchase is made.
* The online bookstore application helps vendors to set up books or sale in a digital environment and the customers can easily browse through the books.
# Objectives
* This online bookstore aims to provide insight into the essence of an online bookstore through a simple medium by simulating the working of an actual online bookstore.
# Project description
* This project is an implementation of an online Book store in android studio and java language which is similar to the existing online shopping websites like Amazon and ebay.

Each user can sign up/Log in as a customer as well as guest. Customers can search for books and advance search which includes filters like price range, binding , publication year, authors, translators etc. It further gives information about book (description,details).Books are categorised in new released , Top 100/50 books , Specialoffers etc.

customers are also able to share or comment for each item and add their favorite products to the wishlist.

# Configuration 
* Android studio 4.1.3
* Butterknife 10.2.1
* Min Android version 6 

# Functions 
* POJO classes
* Fragments
* Java classes
# Requirement
* android {
*    compileSdkVersion 29
*    buildToolsVersion "29.0.2"
*    defaultConfig {
*        applicationId "com.example.NVBookstore"
*        minSdkVersion 15
*        targetSdkVersion 29
*        versionCode 1
*        versionName "1.0"
*        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
*    }
*   compileOptions {
*       sourceCompatibility JavaVersion.VERSION_1_8
*        targetCompatibility JavaVersion.VERSION_1_8
*    }
*    buildTypes {
*        release {
*            minifyEnabled false
*            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
*        }
*    }
* }
# Dependencies
* implementation fileTree(dir: 'libs', include: ['*.jar'])
 * implementation 'androidx.appcompat:appcompat:1.1.0'
   * implementation 'com.google.android.material:material:1.0.0'
    * implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    * implementation 'androidx.vectordrawable:vectordrawable:1.0.1'
    * implementation 'androidx.navigation:navigation-fragment:2.0.0'
    * implementation 'androidx.navigation:navigation-ui:2.0.0'
    * implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'
    * implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    * testImplementation 'junit:junit:4.12'
    * androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    * androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

    //imageview
   * implementation 'de.hdodenhof:circleimageview:3.1.0'

    //   ------------------------------- Butterknife-------------------------------------
   * implementation 'com.jakewharton:butterknife:10.2.1'
   * annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.1'
   * implementation 'com.android.support:cardview-v7:28.0.0'
   * implementation 'com.android.support.constraint:constraint-layout:1.1.3'

   * implementation 'com.github.Innovattic:range-seek-bar:v1.0.6'
# Feature list
* Book-Details
* Explore as guest
* Wishlist
* Share
* Add to cart
* Filters (Search by authors name, Year, Binding, etc.)
* Categories
* Checkout
* Payment methods(Cards,Paypal,Net banking,Cash on Delivery)
* Confirm order
* Profile (My Orders, Customer Support, Notifications, Shipping Address, Edit Profile)
* Order status 


# Manifest (Files)
* ![ss1](https://user-images.githubusercontent.com/83035846/115806691-3cd60880-a3b5-11eb-9bfc-f36ee1638c7b.png)
* ![ss2](https://user-images.githubusercontent.com/83035846/115806693-3d6e9f00-a3b5-11eb-86fd-a4db8c1da6a0.png)



# Screenshots

https://user-images.githubusercontent.com/83035846/115803997-0e096380-a3b0-11eb-97b5-81b525dee335.mp4



# APP Logo : ![projectlogo](https://user-images.githubusercontent.com/83035846/115798075-6128e980-a3a3-11eb-8dd2-e0e9c74c22a5.png)
# Project Logo :![applogo](https://user-images.githubusercontent.com/83035846/115798078-62f2ad00-a3a3-11eb-937c-0bb26dab8b3a.png)


# Contact information
* nimeshvaddoriya61@gmail.com
* Contact: 807-709-9079

