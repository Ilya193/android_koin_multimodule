Пример многомодульного проекта с использованием koin  

RootFragment в :feature:messages создает MessagesDepsViewModel, куда отдает все зависимости для этой фичи  
При навигации на MessagesFragment отдается репозиторий, который живет ровно столько, сколько живет фича  
Репозиторий создается через factory, однако при перевороте экрана он НЕ будет пересоздаваться, так как MessagesDepsViewModel держит на него ссылку

Архитектура  
![arch](https://github.com/user-attachments/assets/68ea041b-d055-4189-96ae-1b32a51f4d18)
