import SwiftUI
import shared

struct ContentView: View {
        
	var body: some View {
        let a = Greeting().greet()
        let b = StartDiHelper().getCharacters { character, error in
            character != nil ? print(character!) : print("nil value")
        }
		Text(a)
	}
}
