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
            VStack{
                ZStack(alignment: .bottomTrailing) {
                    Image("photo_hall")
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                        .edgesIgnoringSafeArea(.all)
                    Image("loggy")

                }.frame(width: geometry.size.width, height: geometry.size.height * 0.8).padding(.leading,-50)
                        
                HStack{
                    //Boite de texte et Boutton
                    Button(action: {
                        listeDialogue = "Suivant"
                    }, label: {
                        Text("Suiv")
                    })
                    Button(action: {
                        listeDialogue = "Précédent"
                    }, label: {
                        Text("Préc")
                    })

                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

