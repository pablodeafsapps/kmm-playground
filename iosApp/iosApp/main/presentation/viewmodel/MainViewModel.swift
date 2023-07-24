//
//  MainViewModel.swift
//  iosApp
//
//  Created by Pablo L. Sordo Martinez on 24/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

// 'ViewModels' should always be marked with '@MainActor' so updates are dispatched in the main thread
@MainActor
class MainViewModel: CommonMainViewModel, ObservableObject {
    
    @Published
    var characters: [Character] = []
    
    init() {
        super.init(characsDataSource: StartDiHelper().getCharactersDataSource)
        getCharacters { [weak self] getCharactersResult, _ in
            getCharactersResult?
                .onSuccess(action: { chars in
                    guard let characters = chars as? [Character] else { return }
                    DispatchQueue.main.async {
                        self?.characters = characters
                    }
                }).onFailure(action: { err in
                    guard let error = err as? Error else { return }
                    print(error.formattedDescription())
                })
        }
    }
}
