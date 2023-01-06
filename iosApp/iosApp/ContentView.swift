import SwiftUI
import shared
struct ContentView: View {
    @State private var showNextScreen = false

    var body: some View {
        VStack {
            Button(action: {
                self.showNextScreen = true
            }) {
                Text("Jouer")
            }
        }
        if showNextScreen{
                PremiereCinematique()
                    .frame(
                        width: UIScreen.main.bounds.width,
                        height: UIScreen.main.bounds.height
                    )
                }
    }
}
struct PremiereCinematique: View {
    @State var listeDialogue : String = "Bonjour"
    var body: some View {
        GeometryReader { geometry in
            VStack {
                // Contenu du VStack
                Image("photo_hall")
                    .resizable()
                    .scaledToFill()
                
            }.frame(width: geometry.size.width * 1, height: geometry.size.height *
                        0.85)
            HStack{
                //Boite de texte et Boutton
                Button(action: {
                    listeDialogue = "ok"
                    print(listeDialogue)
                }, label: {
                    Text("Suivant")
                })
            }
            
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

