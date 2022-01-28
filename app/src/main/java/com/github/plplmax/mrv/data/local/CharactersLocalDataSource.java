package com.github.plplmax.mrv.data.local;

import java.util.List;

public interface CharactersLocalDataSource {
    List<CharacterEntity> fetchCharactersWithOffset(int offset);

    List<CharacterEntity> fetchCharactersWithLimit(int limit);

    void saveCharacters(List<CharacterEntity> characters);

    class Base implements CharactersLocalDataSource {
        private final CharacterDao dao;

        public Base(CharacterDao dao) {
            this.dao = dao;
        }

        @Override
        public List<CharacterEntity> fetchCharactersWithOffset(int offset) {
            return dao.fetchCharactersWithOffset(offset);
        }

        @Override
        public List<CharacterEntity> fetchCharactersWithLimit(int limit) {
            return dao.fetchCharactersWithLimit(limit);
        }

        @Override
        public void saveCharacters(List<CharacterEntity> characters) {
            dao.saveCharacters(characters);
        }
    }
}