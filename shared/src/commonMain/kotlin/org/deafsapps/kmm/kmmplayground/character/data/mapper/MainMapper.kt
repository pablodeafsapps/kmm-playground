package org.deafsapps.kmm.kmmplayground.character.data.mapper

import org.deafsapps.kmm.kmmplayground.character.data.model.CharacterDto
import org.deafsapps.kmm.kmmplayground.character.data.model.LocationDto
import org.deafsapps.kmm.kmmplayground.character.data.model.OriginDto
import org.deafsapps.kmm.kmmplayground.character.domain.model.Character
import org.deafsapps.kmm.kmmplayground.character.domain.model.Location
import org.deafsapps.kmm.kmmplayground.character.domain.model.Origin

fun List<CharacterDto>.toBo(): List<Character> = map { character -> character.toBo() }

private fun CharacterDto.toBo(): Character = Character(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin.toBo(),
    location = location.toBo(),
    image = image,
    episode = episode,
    url = url,
    created = created,
)

private fun OriginDto.toBo(): Origin = Origin(
    name = name, url = url
)

private fun LocationDto.toBo(): Location = Location(
    name = name, url = url
)
