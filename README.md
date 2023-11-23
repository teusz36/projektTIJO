# README #

# Nazwa kursu
Testowanie i Jakość Oprogramowania (Projekt)

# Autorzy
Mateusz Tarchała i Jakub Rodak

# Temat projektu
Aplikacja do gry w statki

# Opis projektu
Po rozpoczęciu rozgrywki użytkownik ma możliwość ustawienia swoich statków na planszy. Po rozmieszczeniu statków przez gracza wczytywane jest rozmieszczenie dla AI i rozpoczyna się gra. Wyświetlane są dwie plansze: plansza z ustawieniem statków gracza, do której strzelać będzie AI, oraz pusta plansza, do której będzie strzelał gracz. Strzał odbywa się przez wybranie pola na planszy przeciwnika. Jeśli gracz trafi, dostaje następny ruch. Jeśli spudłuje, kolej przechodzi na AI.
Jeśli gracz lub AI trafi, wszystkie statki przeciwnika wygrywa i gra się kończy.

# Uruchomienie projektu

# Uruchomienie testów jednostkowych i integracyjnych

# Dokumentacja API

# Scenariusze testowe dla testera manualnego
| Test Case ID | Opis | Kroki testowe | Oczekiwany wynik |
|------------|------------|------------|------------|
| TC_01 | Test sprawdza poprawność inicjacji nowej rozgrywki.| 1. Uruchom grę. <br/>2. Wybierz opcję „Nowa gra”. <br/>3. Wygeneruj swoją planszę. | Nowa gra powinna być przygotowana z wybranymi przez nas polami.|
| TC_02 | Test czytelności i intuicyjności interfejsu gry.| 1. Przeglądaj interfejs gry <br/>2. Kliknij na różne elementy interfejsu, takie jak przyciski strzałów, plansze itd. |Interfejs powinien być czytelny, zrozumiały, a akcje użytkownika powinny być łatwe do wykonania.|
| TC_03 | Test, jak gra reaguje na błędne ruchy gracza.| 1. Spróbuj wykonać strzał poza granicami planszy <br/>2. Spróbuj umieścić statek w niedozwolony sposób. | Gra powinna wyświetlić komunikat informujący o błędzie i uniemożliwić wykonanie niepoprawnej akcji.|
| TC_04 | Test poprawności zakończenia gry po zatopieniu wszystkich statków przeciwnika.| 1. Graj tak długo aż zatopisz wszystkie statki przeciwnika. <br/>2. Obserwuj ekran końcowy gry.| Gra powinna poprawnie zakończyć się, wyświetlając ekran podsumowujący zwycięstwo. |
| TC_05 | Test płynności gry podczas intensywnej rozgrywki.| 1. Umieść statki na planszy.<br/> 2. Wykonaj szybkie strzały. |Gra powinna zachować płynność bez opóźnień czy zawieszeń.|
| TC_06 | Test reakcji gry na ruchy komputerowego przeciwnika.| 1. Uruchom grę z trybem gry przeciwko komputerowi. <br/> 2. Obserwuj ruchy komputerowego przeciwnika. |Ruchy komputerowego przeciwnika powinny być logiczne, a gra powinna skutecznie odpowiadać na akcje gracza.|
| TC_07 | Test, czy po zniszczeniu statku pola bezpośrednio obok niego są poprawnie oznaczane.| 1. Zniszcz jeden z statków na planszy. <br/> 2. Sprawdź pola bezpośrednio sąsiadujące z zatopionym statkiem. |Pola bezpośrednio obok zatopionego statku powinny być poprawnie oznaczone, np. jako pola, na których statki nie mogą być ustawione.|
| TC_08 | Test, czy gra uniemożliwia zatopienie własnych statków.| 1. Spróbuj celować w swoje statki i zatapiać je. |Gra nie powinna zezwalać na celowanie i zatapianie własnych statków.|
| TC_09 | Testuje reakcję gry na próby umieszczenia statków w miejscach, gdzie się kolidują.| 1. Umieszczaj statki w miejscach, gdzie mogą się nachodzić.| Gra powinna uniemożliwić kolidowanie się statków, informując o błędzie i wymagając ponownego rozmieszczenia.|
| TC_10 | Testuje poprawność zamykania gry | 1. Uruchom grę. <br/> 2. Zakończ grę |Gra powinna się zakończyć. |

# Technologie użyte w projekcie
InteliJ IDEA, GitHub


