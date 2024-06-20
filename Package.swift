// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "OfflineMap",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "OfflineMap",
            targets: ["OfflineMapPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "OfflineMapPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/OfflineMapPlugin"),
        .testTarget(
            name: "OfflineMapPluginTests",
            dependencies: ["OfflineMapPlugin"],
            path: "ios/Tests/OfflineMapPluginTests")
    ]
)