import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        InitDiHelperKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
