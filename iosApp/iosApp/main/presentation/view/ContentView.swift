import SwiftUI
import shared

struct ContentView: View {
        
    @State
    var characters: [Character] = []
    
    @StateObject
    var contentViewModel: MainViewModel = MainViewModel()

	var body: some View {
        List(contentViewModel.characters, id: \.self) { item in
            Text(item.name)
        }
    }
}
