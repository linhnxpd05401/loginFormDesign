USE [master]
GO
/****** Object:  Database [TheLEAAcademy]    Script Date: 01/08/2022 12:29:43 CH ******/
CREATE DATABASE [TheLEAAcademy]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TheLEAAcademy', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MYDB\MSSQL\DATA\TheLEAAcademy.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TheLEAAcademy_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MYDB\MSSQL\DATA\TheLEAAcademy_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TheLEAAcademy] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TheLEAAcademy].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TheLEAAcademy] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET ARITHABORT OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [TheLEAAcademy] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TheLEAAcademy] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TheLEAAcademy] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TheLEAAcademy] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TheLEAAcademy] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TheLEAAcademy] SET  MULTI_USER 
GO
ALTER DATABASE [TheLEAAcademy] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TheLEAAcademy] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TheLEAAcademy] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TheLEAAcademy] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [TheLEAAcademy] SET DELAYED_DURABILITY = DISABLED 
GO
USE [TheLEAAcademy]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 01/08/2022 12:29:43 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[AccountID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Role] [bit] NOT NULL,
	[VerifyCode] [nvarchar](6) NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_Accounts] PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Announce]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Announce](
	[Tag] [nvarchar](255) NOT NULL,
	[Content] [nvarchar](max) NULL,
	[DateCreate] [date] NULL,
	[UserID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Tag] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[AnswersAndQuestionsForExercise]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AnswersAndQuestionsForExercise](
	[QuestionID] [int] IDENTITY(1,1) NOT NULL,
	[SubjectID] [int] NOT NULL,
	[Request] [nvarchar](255) NOT NULL,
	[QuestionContent] [nvarchar](500) NOT NULL,
	[Answer1] [nvarchar](255) NOT NULL,
	[Answer2] [nvarchar](255) NOT NULL,
	[Answer3] [nvarchar](255) NOT NULL,
	[Answer4] [nvarchar](255) NOT NULL,
	[RightAnswer] [nvarchar](255) NOT NULL,
	[Point] [int] NOT NULL,
 CONSTRAINT [PK_AnswersAndQuestionsForExercise] PRIMARY KEY CLUSTERED 
(
	[QuestionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[AnswersAndQuestionsForTest]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AnswersAndQuestionsForTest](
	[QuestionID] [int] IDENTITY(1,1) NOT NULL,
	[TestID] [int] NOT NULL,
	[Request] [nvarchar](255) NOT NULL,
	[QuestionContent] [nvarchar](500) NOT NULL,
	[Answer1] [nvarchar](255) NOT NULL,
	[Answer2] [nvarchar](255) NOT NULL,
	[Answer3] [nvarchar](255) NOT NULL,
	[Answer4] [nvarchar](255) NOT NULL,
	[RightAnswer] [nvarchar](255) NOT NULL,
	[Point] [int] NOT NULL,
 CONSTRAINT [PK_AnswersAndQuestionsForTest] PRIMARY KEY CLUSTERED 
(
	[QuestionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LearningProcess]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LearningProcess](
	[ProcessID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[SubjectID] [int] NOT NULL,
	[Mark] [int] NOT NULL,
	[LearningDay] [date] NOT NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_LearningProcess] PRIMARY KEY CLUSTERED 
(
	[ProcessID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Rate]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rate](
	[RateID] [int] IDENTITY(1,1) NOT NULL,
	[Star] [int] NULL,
	[Comment] [nvarchar](max) NULL,
	[UserID] [int] NULL,
	[Date] [date] NULL,
 CONSTRAINT [PK_Rate] PRIMARY KEY CLUSTERED 
(
	[RateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Subject]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject](
	[SubjectID] [int] IDENTITY(1,1) NOT NULL,
	[SubjectName] [nvarchar](50) NOT NULL,
	[Note] [nvarchar](255) NULL,
	[SubjectImage] [nvarchar](50) NULL,
	[PassingPoint] [int] NULL,
 CONSTRAINT [PK_Subject] PRIMARY KEY CLUSTERED 
(
	[SubjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Test]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Test](
	[TestID] [int] IDENTITY(1,1) NOT NULL,
	[Level] [int] NOT NULL,
	[NumberOfQuestions] [int] NOT NULL,
	[Time] [int] NULL,
	[TestName] [nvarchar](50) NULL,
	[PassingPoint] [int] NULL,
	[NumberOfCoinForUnlock] [int] NULL,
 CONSTRAINT [PK_Test] PRIMARY KEY CLUSTERED 
(
	[TestID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestingProcess]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestingProcess](
	[ProcessID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[TestID] [int] NOT NULL,
	[Mark] [int] NOT NULL,
	[TestingDate] [date] NOT NULL,
	[Status] [bit] NULL,
 CONSTRAINT [PK_TestingProcess] PRIMARY KEY CLUSTERED 
(
	[ProcessID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Theory]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Theory](
	[TheoryID] [int] IDENTITY(1,1) NOT NULL,
	[UnitID] [int] NOT NULL,
	[TheoryContent] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Theory] PRIMARY KEY CLUSTERED 
(
	[TheoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Units]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Units](
	[UnitID] [int] IDENTITY(1,1) NOT NULL,
	[SubjectID] [int] NOT NULL,
	[UnitName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Units] PRIMARY KEY CLUSTERED 
(
	[UnitID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserProfile]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserProfile](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[AccountID] [int] NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Birthday] [date] NULL,
	[Gender] [bit] NULL,
	[Email] [nvarchar](50) NOT NULL,
	[PhoneNumber] [nvarchar](13) NULL,
	[Address] [nvarchar](255) NULL,
	[Image] [nvarchar](50) NULL,
	[Coin] [int] NULL,
	[RegistrasionDate] [date] NULL,
 CONSTRAINT [PK_UserProfile] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Accounts] ON 

INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (1, N'admin', N'123456', 1, N'633586', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (2, N'linhnxpd05401@gmail.com', N'123456', 0, N'000000', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (3, N'user01@gmail.com', N'123456', 0, N'000000', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (7, N'nxlinh.12b10.pdl@gmail.com', N'123', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (8, N'bimzc123@gmail.com', N'123', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (9, N'lethihoa@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (11, N'buivan manh@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (12, N'hoangvannghia@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (13, N'tranvanbinh@gmail.om', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (15, N'quanthpd05478@fpt.edu.vn', N'120200', 1, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (16, N'thaivanminh@gmail.om', N'123123', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (17, N'lvhung@gmail.com', N'11111', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (18, N'kamisama@gmail.com', N'159159159', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (19, N'bimzc123@gmail.com', N'1111', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (20, N'abc1@gmail.com', N'123456', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (21, N'abc2@gmail.com', N'123456', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (22, N'abc3@gmail.com', N'123456', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (23, N'abc4@gmail.com', N'123', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (24, N'abc5@gmail.com', N'123', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (25, N'anb@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (26, N'lkj@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (27, N'nmh@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (28, N'polk@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (29, N'asd@gmail.com', N'120200', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (30, N'nhung@gmail.com', N'123123', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (31, N'hoang@gmail.com', N'11111', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (32, N'minh@gmail.com', N'159159159', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (33, N'gut@gmail.com', N'1111', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (34, N'giang@gmail.com', N'123456', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (35, N'mai@gmail.com', N'123456', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (36, N'hac@gmail.com', N'123456', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (37, N'lao@gmail.com', N'123', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (38, N'huyen@gmail.com', N'123', 0, N'', 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (39, N'khuong@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (40, N'taka@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (41, N'bo@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (42, N'bim@gmail.com', N'1', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (43, N'pubg@gmail.com', N'120200', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (44, N'abct@gmail.com', N'123123', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (45, N'36gaming@gmail.com', N'11111', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (46, N'ccmo@gmail.com', N'159159159', 0, NULL, 1)
INSERT [dbo].[Accounts] ([AccountID], [Email], [Password], [Role], [VerifyCode], [Status]) VALUES (47, N'gaming@gmail.com', N'1111', 0, NULL, 1)
SET IDENTITY_INSERT [dbo].[Accounts] OFF
INSERT [dbo].[Announce] ([Tag], [Content], [DateCreate], [UserID]) VALUES (N'Fix', N'There is a bug that you guys reported was fixed !! Thanks', CAST(N'2022-07-27' AS Date), 16)
INSERT [dbo].[Announce] ([Tag], [Content], [DateCreate], [UserID]) VALUES (N'Hi guys', N'Welcome to our beta versions.We are so happy when we release this version to help you guys learning english at home.Any prolem you find,you cand send it to our Email : leaacademy@englishcenter.vn or Hotline : 0944940583', CAST(N'2022-01-09' AS Date), 16)
INSERT [dbo].[Announce] ([Tag], [Content], [DateCreate], [UserID]) VALUES (N'Maintance', N'We are going to maintance the App to fix problems when you are experience in Beta Version and update new feature.Waiting and see new feature after we done.Please do not enter the App while sever is maintaining', CAST(N'2022-01-25' AS Date), 1)
INSERT [dbo].[Announce] ([Tag], [Content], [DateCreate], [UserID]) VALUES (N'New Feature Map', N'Today we release Map version ,you can open this and find our centre location ', CAST(N'2022-05-08' AS Date), 16)
INSERT [dbo].[Announce] ([Tag], [Content], [DateCreate], [UserID]) VALUES (N'Official Release', N'At 15/02/2022 we will realese the official version on our website,waiting for news in your mail or visit our website TheLeaAccaddemy.com', CAST(N'2022-03-08' AS Date), 1)
INSERT [dbo].[Announce] ([Tag], [Content], [DateCreate], [UserID]) VALUES (N'Open Beta', N'Hi guys ,Open Beta Version for 20 days', CAST(N'2022-07-29' AS Date), 16)
INSERT [dbo].[Announce] ([Tag], [Content], [DateCreate], [UserID]) VALUES (N'Please Rate', N'We need your Rate to help us improve.Click on rate next to your avatar in the Home Page .Thanks', CAST(N'2022-07-08' AS Date), 1)
SET IDENTITY_INSERT [dbo].[AnswersAndQuestionsForExercise] ON 

INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (1, 1, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (2, 1, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (3, 1, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (4, 1, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (5, 1, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (6, 2, N'Choose the best answer :', N'Do you _____ to go out with me tonight?			', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (7, 2, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (8, 2, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (9, 2, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (10, 2, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (11, 2, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (12, 2, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (13, 2, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (14, 2, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (15, 3, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (16, 3, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (17, 3, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (18, 3, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (19, 3, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (20, 3, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (21, 3, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (22, 4, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (23, 4, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (24, 4, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (25, 4, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (26, 4, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (27, 4, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (28, 4, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (29, 5, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (30, 5, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (31, 5, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (32, 5, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (33, 5, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (34, 5, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (35, 5, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (36, 5, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (37, 14, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (38, 14, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (39, 14, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (40, 14, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (41, 14, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (42, 14, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (43, 15, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (44, 15, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (45, 15, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (46, 15, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (47, 15, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (48, 15, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (49, 16, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (50, 16, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (51, 16, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (52, 16, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (53, 16, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (54, 16, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (55, 16, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (56, 17, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (57, 17, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (58, 17, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (59, 17, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (60, 17, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (61, 17, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (62, 17, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (63, 18, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (64, 18, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (65, 18, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (66, 18, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (67, 18, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (68, 18, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (69, 18, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (70, 19, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (71, 19, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (72, 19, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (73, 19, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (74, 19, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (75, 19, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (76, 19, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (77, 19, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (78, 20, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (79, 20, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (80, 20, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (81, 20, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (82, 20, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (83, 20, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (84, 20, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (85, 21, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (86, 21, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (87, 21, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (88, 21, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (89, 21, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (90, 21, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (91, 22, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (92, 22, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (93, 22, N'Choose the correct answer.', N' Who are ________ him?', N'their', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (94, 22, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (95, 22, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (96, 22, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (97, 22, N'Choose the best answer :', N'Do you _____ to go out with me tonight?   ', N'want', N'go', N'went', N'gone', N'want', 1)
INSERT [dbo].[AnswersAndQuestionsForExercise] ([QuestionID], [SubjectID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (98, 22, N'Order Right Position To Complete The Sentence : ', N'Been / have / you / American / to / before ?', N'Have you been to American before ?', N'Have you to been American before ?', N'Have before you been to American  ?', N'Have you been before to American  ?', N'Have you been to American before ?', 1)
SET IDENTITY_INSERT [dbo].[AnswersAndQuestionsForExercise] OFF
GO
SET IDENTITY_INSERT [dbo].[AnswersAndQuestionsForTest] ON 

INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (1, 1, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (2, 1, N'Choose the correct answer', N' Claude is ________', N'Frenchman', N'a French', N'a Frenchman', N'French man', N'a French', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (3, 1, N'Choose the correct answer', N'I ____ a car next year.', N'buy', N'am buying', N'going to buy', N'bought', N'am buying', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (4, 1, N'Choose the correct answer', N'They are all ________ ready for the party.', N'getting', N'going', N'doing', N'putting', N'getting', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (5, 1, N'Choose the correct answer', N'When do you go ________ bed?', N'to', N'to the', N'in', N'in the', N'to', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (6, 1, N'Choose the correct answer', N'London is famous for _____ red buses.', N'it’s', N'its', N'it', N'it is', N'its', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (7, 1, N'Choose the correct answer', N'Is there _____ milk in the fridge?', N'a lot', N'many', N'much', N'some', N'some', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (8, 1, N'Choose the correct answer', N'There is a flower shop in front _____ my house.', N'of', N'to', N'off', N'in', N'of', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (9, 1, N'Choose the correct answer', N'Where are _____ children? – They go to school.', N'the', N'you', N'a', N'an', N'the', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (10, 1, N'Choose the correct answer', N'Those students are working very _____ for their next exams.', N'hardly', N'hard', N'harder', N'hardest', N'hard', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (11, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (12, 1, N'Choose the correct answer', N'Dan can _____ the drum very well.', N'play', N'do', N'make', N'think', N'play', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (13, 1, N'Choose the correct answer', N'My friend is ______ so she has a lot of free time.', N'singer', N'married', N'single', N'free', N'single', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (14, 1, N'Choose the correct answer', N'I know somebody ________ can play the guitar.', N'he', N'who', N'what', N'that he', N'who', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (15, 1, N'Choose the correct answer', N'Did you ask your father ________ some money?', N'0', N'after', N'on', N'for', N'for', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (16, 1, N'Choose the correct answer', N'You look ________ in red!', N'most nicely', N'too nice', N'nicely', N'very nice', N'very nice', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (17, 1, N'Choose the correct answer', N'We know their address, but they don’t know ________.', N'ours', N'their’s', N'our’s', N'our', N'ours', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (18, 1, N'Choose the correct answer', N'Can you use ________ computer?', N'a', N'one', N'two', N'an', N'a', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (19, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (20, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (21, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (22, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (23, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (24, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (25, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (26, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (27, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (28, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (29, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (30, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (31, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (32, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (33, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (34, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (35, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (36, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (37, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (38, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (39, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (40, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (41, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (42, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (43, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (44, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (45, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (46, 2, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (47, 2, N'Choose the correct answer', N' Claude is ________', N'Frenchman', N'a French', N'a Frenchman', N'French man', N'a French', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (48, 2, N'Choose the correct answer', N'I ____ a car next year.', N'buy', N'am buying', N'going to buy', N'bought', N'am buying', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (49, 2, N'Choose the correct answer', N'They are all ________ ready for the party.', N'getting', N'going', N'doing', N'putting', N'getting', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (50, 2, N'Choose the correct answer', N'When do you go ________ bed?', N'to', N'to the', N'in', N'in the', N'to', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (51, 2, N'Choose the correct answer', N'London is famous for _____ red buses.', N'it’s', N'its', N'it', N'it is', N'its', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (52, 2, N'Choose the correct answer', N'Is there _____ milk in the fridge?', N'a lot', N'many', N'much', N'some', N'some', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (53, 2, N'Choose the correct answer', N'There is a flower shop in front _____ my house.', N'of', N'to', N'off', N'in', N'of', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (54, 2, N'Choose the correct answer', N'Where are _____ children? – They go to school.', N'the', N'you', N'a', N'an', N'the', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (55, 2, N'Choose the correct answer', N'Those students are working very _____ for their next exams.', N'hardly', N'hard', N'harder', N'hardest', N'hard', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (56, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (57, 2, N'Choose the correct answer', N'Dan can _____ the drum very well.', N'play', N'do', N'make', N'think', N'play', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (58, 2, N'Choose the correct answer', N'My friend is ______ so she has a lot of free time.', N'singer', N'married', N'single', N'free', N'single', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (59, 2, N'Choose the correct answer', N'I know somebody ________ can play the guitar.', N'he', N'who', N'what', N'that he', N'who', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (60, 2, N'Choose the correct answer', N'Did you ask your father ________ some money?', N'0', N'after', N'on', N'for', N'for', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (61, 2, N'Choose the correct answer', N'You look ________ in red!', N'most nicely', N'too nice', N'nicely', N'very nice', N'very nice', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (62, 2, N'Choose the correct answer', N'We know their address, but they don’t know ________.', N'ours', N'their’s', N'our’s', N'our', N'ours', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (63, 2, N'Choose the correct answer', N'Can you use ________ computer?', N'a', N'one', N'two', N'an', N'a', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (64, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (65, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (66, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (67, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (68, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (69, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (70, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (71, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (72, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (73, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (74, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (75, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (76, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (77, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (78, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (79, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (80, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (81, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (82, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (83, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (84, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (85, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (86, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (87, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (88, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (89, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (90, 2, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (91, 3, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (92, 3, N'Choose the correct answer', N' Claude is ________', N'Frenchman', N'a French', N'a Frenchman', N'French man', N'a French', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (93, 3, N'Choose the correct answer', N'I ____ a car next year.', N'buy', N'am buying', N'going to buy', N'bought', N'am buying', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (94, 3, N'Choose the correct answer', N'They are all ________ ready for the party.', N'getting', N'going', N'doing', N'putting', N'getting', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (95, 3, N'Choose the correct answer', N'When do you go ________ bed?', N'to', N'to the', N'in', N'in the', N'to', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (96, 3, N'Choose the correct answer', N'London is famous for _____ red buses.', N'it’s', N'its', N'it', N'it is', N'its', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (97, 3, N'Choose the correct answer', N'Is there _____ milk in the fridge?', N'a lot', N'many', N'much', N'some', N'some', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (98, 3, N'Choose the correct answer', N'There is a flower shop in front _____ my house.', N'of', N'to', N'off', N'in', N'of', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (99, 3, N'Choose the correct answer', N'Where are _____ children? – They go to school.', N'the', N'you', N'a', N'an', N'the', 1)
GO
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (100, 3, N'Choose the correct answer', N'Those students are working very _____ for their next exams.', N'hardly', N'hard', N'harder', N'hardest', N'hard', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (101, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (102, 3, N'Choose the correct answer', N'Dan can _____ the drum very well.', N'play', N'do', N'make', N'think', N'play', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (103, 3, N'Choose the correct answer', N'My friend is ______ so she has a lot of free time.', N'singer', N'married', N'single', N'free', N'single', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (104, 3, N'Choose the correct answer', N'I know somebody ________ can play the guitar.', N'he', N'who', N'what', N'that he', N'who', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (105, 3, N'Choose the correct answer', N'Did you ask your father ________ some money?', N'0', N'after', N'on', N'for', N'for', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (106, 3, N'Choose the correct answer', N'You look ________ in red!', N'most nicely', N'too nice', N'nicely', N'very nice', N'very nice', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (107, 3, N'Choose the correct answer', N'We know their address, but they don’t know ________.', N'ours', N'their’s', N'our’s', N'our', N'ours', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (108, 3, N'Choose the correct answer', N'Can you use ________ computer?', N'a', N'one', N'two', N'an', N'a', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (109, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (110, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (111, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (112, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (113, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (114, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (115, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (116, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (117, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (118, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (119, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (120, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (121, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (122, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (123, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (124, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (125, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (126, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (127, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (128, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (129, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (130, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (131, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (132, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (133, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (134, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (135, 3, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (136, 4, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (137, 4, N'Choose the correct answer', N' Claude is ________', N'Frenchman', N'a French', N'a Frenchman', N'French man', N'a French', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (138, 4, N'Choose the correct answer', N'I ____ a car next year.', N'buy', N'am buying', N'going to buy', N'bought', N'am buying', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (139, 4, N'Choose the correct answer', N'They are all ________ ready for the party.', N'getting', N'going', N'doing', N'putting', N'getting', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (140, 4, N'Choose the correct answer', N'When do you go ________ bed?', N'to', N'to the', N'in', N'in the', N'to', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (141, 4, N'Choose the correct answer', N'London is famous for _____ red buses.', N'it’s', N'its', N'it', N'it is', N'its', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (142, 4, N'Choose the correct answer', N'Is there _____ milk in the fridge?', N'a lot', N'many', N'much', N'some', N'some', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (143, 4, N'Choose the correct answer', N'There is a flower shop in front _____ my house.', N'of', N'to', N'off', N'in', N'of', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (144, 4, N'Choose the correct answer', N'Where are _____ children? – They go to school.', N'the', N'you', N'a', N'an', N'the', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (145, 4, N'Choose the correct answer', N'Those students are working very _____ for their next exams.', N'hardly', N'hard', N'harder', N'hardest', N'hard', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (146, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (147, 4, N'Choose the correct answer', N'Dan can _____ the drum very well.', N'play', N'do', N'make', N'think', N'play', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (148, 4, N'Choose the correct answer', N'My friend is ______ so she has a lot of free time.', N'singer', N'married', N'single', N'free', N'single', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (149, 4, N'Choose the correct answer', N'I know somebody ________ can play the guitar.', N'he', N'who', N'what', N'that he', N'who', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (150, 4, N'Choose the correct answer', N'Did you ask your father ________ some money?', N'0', N'after', N'on', N'for', N'for', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (151, 4, N'Choose the correct answer', N'You look ________ in red!', N'most nicely', N'too nice', N'nicely', N'very nice', N'very nice', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (152, 4, N'Choose the correct answer', N'We know their address, but they don’t know ________.', N'ours', N'their’s', N'our’s', N'our', N'ours', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (153, 4, N'Choose the correct answer', N'Can you use ________ computer?', N'a', N'one', N'two', N'an', N'a', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (154, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (155, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (156, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (157, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (158, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (159, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (160, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (161, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (162, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (163, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (164, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (165, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (166, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (167, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (168, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (169, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (170, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (171, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (172, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (173, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (174, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (175, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (176, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (177, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (178, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (179, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (180, 4, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (181, 4, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (182, 5, N'Choose the correct answer', N' Claude is ________', N'Frenchman', N'a French', N'a Frenchman', N'French man', N'a French', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (183, 5, N'Choose the correct answer', N'I ____ a car next year.', N'buy', N'am buying', N'going to buy', N'bought', N'am buying', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (184, 5, N'Choose the correct answer', N'They are all ________ ready for the party.', N'getting', N'going', N'doing', N'putting', N'getting', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (185, 5, N'Choose the correct answer', N'When do you go ________ bed?', N'to', N'to the', N'in', N'in the', N'to', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (186, 5, N'Choose the correct answer', N'London is famous for _____ red buses.', N'it’s', N'its', N'it', N'it is', N'its', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (187, 5, N'Choose the correct answer', N'Is there _____ milk in the fridge?', N'a lot', N'many', N'much', N'some', N'some', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (188, 5, N'Choose the correct answer', N'There is a flower shop in front _____ my house.', N'of', N'to', N'off', N'in', N'of', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (189, 5, N'Choose the correct answer', N'Where are _____ children? – They go to school.', N'the', N'you', N'a', N'an', N'the', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (190, 5, N'Choose the correct answer', N'Those students are working very _____ for their next exams.', N'hardly', N'hard', N'harder', N'hardest', N'hard', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (191, 5, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (192, 5, N'Choose the correct answer', N'Dan can _____ the drum very well.', N'play', N'do', N'make', N'think', N'play', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (193, 5, N'Choose the correct answer', N'My friend is ______ so she has a lot of free time.', N'singer', N'married', N'single', N'free', N'single', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (194, 5, N'Choose the correct answer', N'I know somebody ________ can play the guitar.', N'he', N'who', N'what', N'that he', N'who', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (195, 5, N'Choose the correct answer', N'Did you ask your father ________ some money?', N'0', N'after', N'on', N'for', N'for', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (196, 5, N'Choose the correct answer', N'You look ________ in red!', N'most nicely', N'too nice', N'nicely', N'very nice', N'very nice', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (197, 5, N'Choose the correct answer', N'We know their address, but they don’t know ________.', N'ours', N'their’s', N'our’s', N'our', N'ours', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (198, 5, N'Choose the correct answer', N'Can you use ________ computer?', N'a', N'one', N'two', N'an', N'a', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (199, 5, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
GO
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (200, 5, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (201, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (202, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (203, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (204, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (205, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (206, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (207, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (208, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (209, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (210, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (211, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (212, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (213, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (214, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (215, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (216, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (217, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (218, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (219, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (220, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (221, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (222, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (223, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (224, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (225, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (226, 1, N'Choose the correct answer.', N' Who are all ________ people?', N'this', N'those', N'them', N'that', N'those', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (227, 1, N'Choose the correct answer', N' Claude is ________', N'Frenchman', N'a French', N'a Frenchman', N'French man', N'a French', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (228, 1, N'Choose the correct answer', N'I ____ a car next year.', N'buy', N'am buying', N'going to buy', N'bought', N'am buying', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (229, 1, N'Choose the correct answer', N'They are all ________ ready for the party.', N'getting', N'going', N'doing', N'putting', N'getting', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (230, 1, N'Choose the correct answer', N'When do you go ________ bed?', N'to', N'to the', N'in', N'in the', N'to', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (231, 1, N'Choose the correct answer', N'London is famous for _____ red buses.', N'it’s', N'its', N'it', N'it is', N'its', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (232, 1, N'Choose the correct answer', N'Is there _____ milk in the fridge?', N'a lot', N'many', N'much', N'some', N'some', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (233, 1, N'Choose the correct answer', N'There is a flower shop in front _____ my house.', N'of', N'to', N'off', N'in', N'of', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (234, 1, N'Choose the correct answer', N'Where are _____ children? – They go to school.', N'the', N'you', N'a', N'an', N'the', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (235, 1, N'Choose the correct answer', N'Those students are working very _____ for their next exams.', N'hardly', N'hard', N'harder', N'hardest', N'hard', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (236, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (237, 1, N'Choose the correct answer', N'Dan can _____ the drum very well.', N'play', N'do', N'make', N'think', N'play', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (238, 1, N'Choose the correct answer', N'My friend is ______ so she has a lot of free time.', N'singer', N'married', N'single', N'free', N'single', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (239, 1, N'Choose the correct answer', N'I know somebody ________ can play the guitar.', N'he', N'who', N'what', N'that he', N'who', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (240, 1, N'Choose the correct answer', N'Did you ask your father ________ some money?', N'0', N'after', N'on', N'for', N'for', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (241, 1, N'Choose the correct answer', N'You look ________ in red!', N'most nicely', N'too nice', N'nicely', N'very nice', N'very nice', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (242, 1, N'Choose the correct answer', N'We know their address, but they don’t know ________.', N'ours', N'their’s', N'our’s', N'our', N'ours', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (243, 1, N'Choose the correct answer', N'Can you use ________ computer?', N'a', N'one', N'two', N'an', N'a', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (244, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (245, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (246, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (247, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (248, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (249, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (250, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (251, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (252, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (253, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (254, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (255, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (256, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (257, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (258, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (259, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (260, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (261, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (262, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (263, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (264, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (265, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (266, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (267, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (268, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (269, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
INSERT [dbo].[AnswersAndQuestionsForTest] ([QuestionID], [TestID], [Request], [QuestionContent], [Answer1], [Answer2], [Answer3], [Answer4], [RightAnswer], [Point]) VALUES (270, 1, N'Choose the correct answer', N'Jane _____ as a fashion designer for ten years before becoming a famous singer.', N'worked', N'is working', N'works', N'will work', N'worked', 1)
SET IDENTITY_INSERT [dbo].[AnswersAndQuestionsForTest] OFF
SET IDENTITY_INSERT [dbo].[LearningProcess] ON 

INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (1, 2, 1, 66, CAST(N'2022-05-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (14, 2, 2, 55, CAST(N'2022-05-23' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (121, 3, 1, 5, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (122, 1, 1, 5, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (123, 2, 1, 5, CAST(N'2022-07-23' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (124, 7, 1, 5, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (125, 3, 1, 4, CAST(N'2022-07-23' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (126, 6, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (127, 6, 2, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (128, 6, 3, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (129, 11, 3, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (130, 13, 3, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (131, 12, 3, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (132, 12, 4, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (133, 15, 4, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (134, 17, 4, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (135, 19, 4, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (136, 18, 5, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (137, 20, 14, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (138, 22, 15, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (139, 23, 17, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (140, 24, 20, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (141, 25, 22, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (142, 26, 22, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (143, 27, 21, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (144, 28, 16, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (145, 29, 16, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (146, 30, 16, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (147, 31, 17, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (148, 32, 18, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (149, 33, 19, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (150, 34, 22, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (151, 35, 2, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (152, 36, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (153, 37, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (154, 38, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (155, 39, 1, 66, CAST(N'2022-05-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (156, 40, 2, 55, CAST(N'2022-05-23' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (157, 41, 1, 5, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (158, 42, 1, 5, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (159, 43, 1, 5, CAST(N'2022-07-23' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (160, 45, 1, 5, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (161, 44, 1, 4, CAST(N'2022-07-23' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (162, 46, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (163, 47, 2, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (164, 46, 3, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (165, 45, 3, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (166, 44, 3, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (167, 43, 3, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (168, 42, 4, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (169, 41, 4, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (170, 40, 4, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (171, 39, 4, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (172, 38, 5, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (173, 37, 14, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (174, 36, 15, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (175, 35, 17, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (176, 34, 20, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (177, 33, 22, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (178, 32, 22, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (179, 31, 21, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (180, 30, 16, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (181, 29, 16, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (182, 28, 16, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (183, 27, 17, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (184, 26, 18, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (185, 25, 19, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (186, 24, 22, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (187, 23, 2, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (188, 22, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (189, 23, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (190, 24, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (191, 25, 1, 66, CAST(N'2022-05-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (192, 26, 2, 55, CAST(N'2022-05-23' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (193, 27, 1, 5, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (194, 28, 1, 5, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (195, 29, 1, 5, CAST(N'2022-07-23' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (196, 30, 1, 5, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (197, 31, 1, 4, CAST(N'2022-07-23' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (198, 32, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (199, 33, 2, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (200, 34, 3, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (201, 35, 3, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (202, 36, 3, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (203, 37, 3, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (204, 38, 4, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (205, 39, 4, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (206, 40, 4, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (207, 41, 4, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (208, 42, 5, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (209, 43, 14, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (210, 44, 15, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (211, 45, 17, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (212, 46, 20, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (213, 47, 22, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (214, 46, 22, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (215, 45, 21, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (216, 44, 16, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (217, 43, 16, 2, CAST(N'2022-07-27' AS Date), 0)
GO
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (218, 42, 16, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (219, 41, 17, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (220, 40, 18, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (221, 39, 19, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (222, 38, 22, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (223, 37, 2, 2, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (224, 36, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (225, 35, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (226, 34, 2, 2, CAST(N'2022-07-27' AS Date), 1)
INSERT [dbo].[LearningProcess] ([ProcessID], [UserID], [SubjectID], [Mark], [LearningDay], [Status]) VALUES (227, 15, 17, 1, CAST(N'2022-07-30' AS Date), 1)
SET IDENTITY_INSERT [dbo].[LearningProcess] OFF
SET IDENTITY_INSERT [dbo].[Rate] ON 

INSERT [dbo].[Rate] ([RateID], [Star], [Comment], [UserID], [Date]) VALUES (1, 5, N'Good', 1, CAST(N'2022-12-07' AS Date))
INSERT [dbo].[Rate] ([RateID], [Star], [Comment], [UserID], [Date]) VALUES (2, 4, N'Normal', 2, CAST(N'2022-12-08' AS Date))
INSERT [dbo].[Rate] ([RateID], [Star], [Comment], [UserID], [Date]) VALUES (3, 4, N'OK', 3, CAST(N'2022-12-09' AS Date))
INSERT [dbo].[Rate] ([RateID], [Star], [Comment], [UserID], [Date]) VALUES (4, 3, N'quite ok ', 1, CAST(N'2022-07-26' AS Date))
INSERT [dbo].[Rate] ([RateID], [Star], [Comment], [UserID], [Date]) VALUES (5, 2, N'fine', 1, CAST(N'2022-07-26' AS Date))
INSERT [dbo].[Rate] ([RateID], [Star], [Comment], [UserID], [Date]) VALUES (6, 1, N'Normal', 1, CAST(N'2022-07-26' AS Date))
INSERT [dbo].[Rate] ([RateID], [Star], [Comment], [UserID], [Date]) VALUES (7, 5, N'10 điểm ', 1, CAST(N'2022-07-26' AS Date))
SET IDENTITY_INSERT [dbo].[Rate] OFF
SET IDENTITY_INSERT [dbo].[Subject] ON 

INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (1, N'Family and friends', N'OK', N'sbj1.png', 4)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (2, N'School days', NULL, N'sbj2.png', 5)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (3, N'Style', NULL, N'sbj3.png', 4)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (4, N'Food', NULL, N'sbj4.png', 3)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (5, N'In the city', NULL, N'sbj5.png', 5)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (14, N'Technology', N'Hight Lvel', N'sbj2.png', 6)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (15, N'Computer', NULL, N'sbj1.png', 1)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (16, N'SoftWare', NULL, N'sbj3.png', 2)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (17, N'History', NULL, N'sbj5.png', 1)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (18, N'Gesture And Custom', NULL, N'sbj4.png', 9)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (19, N'Driving', NULL, N'sbj5.png', 8)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (20, N'Music', NULL, N'sbj4.png', 6)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (21, N'Movie', NULL, N'sbj4.png', 1)
INSERT [dbo].[Subject] ([SubjectID], [SubjectName], [Note], [SubjectImage], [PassingPoint]) VALUES (22, N'Car', NULL, N'sbj4.png', 5)
SET IDENTITY_INSERT [dbo].[Subject] OFF
SET IDENTITY_INSERT [dbo].[Test] ON 

INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (1, 1, 45, 60, N'Test 1', 40, 50)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (2, 1, 45, 60, N'Test 2', 40, 100)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (3, 1, 45, 60, N'Test 3', 40, 100)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (4, 1, 45, 60, N'Test 4', 40, 100)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (5, 2, 60, 90, N'Test 5', 50, 120)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (6, 2, 60, 90, N'Test 6', 50, 120)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (7, 2, 60, 90, N'Test 7', 50, 130)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (8, 2, 60, 90, N'Test 8', 50, 140)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (9, 3, 70, 120, N'Test 9', 60, 150)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (10, 3, 70, 120, N'Test 10', 60, 150)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (11, 3, 70, 120, N'Test 11', 60, 160)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (12, 3, 70, 120, N'Test 12', 60, 170)
INSERT [dbo].[Test] ([TestID], [Level], [NumberOfQuestions], [Time], [TestName], [PassingPoint], [NumberOfCoinForUnlock]) VALUES (13, 4, 75, 120, N'Final Test', 65, 200)
SET IDENTITY_INSERT [dbo].[Test] OFF
SET IDENTITY_INSERT [dbo].[TestingProcess] ON 

INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (19, 7, 1, 44, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (22, 3, 1, 44, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (23, 6, 1, 42, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (24, 7, 1, 15, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (25, 7, 2, 25, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (26, 2, 2, 45, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (27, 3, 2, 68, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (28, 7, 5, 28, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (33, 11, 5, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (34, 12, 6, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (35, 13, 7, 10, CAST(N'2022-07-08' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (36, 15, 3, 30, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (37, 17, 11, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (38, 7, 13, 49, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (39, 6, 6, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (40, 7, 7, 20, CAST(N'2022-07-29' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (41, 3, 8, 50, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (42, 3, 10, 68, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (43, 2, 9, 85, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (44, 2, 4, 57, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (45, 18, 5, 30, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (46, 19, 6, 83, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (47, 20, 6, 28, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (48, 20, 7, 88, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (49, 3, 8, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (50, 2, 11, 32, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (51, 7, 13, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (52, 12, 11, 40, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (53, 12, 12, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (54, 15, 8, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (55, 13, 8, 80, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (56, 20, 6, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (57, 19, 7, 70, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (58, 22, 1, 44, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (59, 23, 1, 44, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (60, 24, 1, 42, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (61, 25, 1, 15, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (62, 26, 2, 25, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (63, 27, 2, 45, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (64, 28, 2, 68, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (65, 29, 5, 28, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (66, 30, 5, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (67, 31, 6, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (68, 32, 7, 10, CAST(N'2022-07-08' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (69, 33, 3, 30, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (70, 34, 11, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (71, 35, 13, 49, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (72, 36, 6, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (73, 37, 7, 20, CAST(N'2022-07-29' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (74, 38, 8, 50, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (75, 39, 10, 68, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (76, 40, 9, 85, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (77, 41, 4, 57, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (78, 42, 5, 30, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (79, 43, 6, 83, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (80, 44, 6, 28, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (81, 45, 7, 88, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (82, 46, 8, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (83, 47, 11, 32, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (84, 46, 13, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (85, 45, 11, 40, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (86, 44, 12, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (87, 43, 8, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (88, 42, 8, 80, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (89, 41, 6, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (90, 40, 7, 70, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (91, 39, 1, 44, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (92, 38, 1, 44, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (93, 37, 1, 42, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (94, 36, 1, 15, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (95, 35, 2, 25, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (96, 34, 2, 45, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (97, 33, 2, 68, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (98, 32, 5, 28, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (99, 31, 5, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (100, 30, 6, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (101, 29, 7, 10, CAST(N'2022-07-08' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (102, 28, 3, 30, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (103, 27, 11, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (104, 26, 13, 49, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (105, 25, 6, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (106, 24, 7, 20, CAST(N'2022-07-29' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (107, 23, 8, 50, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (108, 22, 10, 68, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (109, 23, 9, 85, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (110, 24, 4, 57, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (111, 7, 5, 30, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (112, 6, 6, 83, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (113, 3, 6, 28, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (114, 3, 7, 88, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (115, 25, 8, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (116, 26, 11, 32, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (117, 27, 13, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (118, 28, 11, 40, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (119, 29, 12, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (120, 30, 8, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (121, 31, 8, 80, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (122, 32, 6, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (123, 33, 7, 70, CAST(N'2022-08-05' AS Date), 1)
GO
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (124, 34, 1, 44, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (125, 35, 1, 44, CAST(N'2022-07-22' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (126, 36, 1, 42, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (127, 37, 1, 15, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (128, 38, 2, 25, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (129, 39, 2, 45, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (130, 40, 2, 68, CAST(N'2022-07-23' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (131, 41, 5, 28, CAST(N'2022-07-27' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (132, 42, 5, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (133, 43, 6, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (134, 44, 7, 10, CAST(N'2022-07-08' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (135, 45, 3, 30, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (136, 46, 11, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (137, 47, 13, 49, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (138, 46, 6, 50, CAST(N'2022-07-08' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (139, 45, 7, 20, CAST(N'2022-07-29' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (140, 44, 8, 50, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (141, 43, 10, 68, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (142, 42, 9, 85, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (143, 41, 4, 57, CAST(N'2022-07-29' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (144, 40, 5, 30, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (145, 39, 6, 83, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (146, 38, 6, 28, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (147, 37, 7, 88, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (148, 36, 8, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (149, 35, 11, 32, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (150, 34, 13, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (151, 33, 11, 40, CAST(N'2022-08-05' AS Date), 0)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (152, 32, 12, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (153, 31, 8, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (154, 30, 8, 80, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (155, 29, 6, 50, CAST(N'2022-08-05' AS Date), 1)
INSERT [dbo].[TestingProcess] ([ProcessID], [UserID], [TestID], [Mark], [TestingDate], [Status]) VALUES (156, 28, 7, 70, CAST(N'2022-08-05' AS Date), 1)
SET IDENTITY_INSERT [dbo].[TestingProcess] OFF
SET IDENTITY_INSERT [dbo].[Theory] ON 

INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (1, 1, N'unit1.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (2, 2, N'unit2.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (3, 3, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (4, 4, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (5, 5, N'unit1.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (6, 6, N'unit2.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (7, 7, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (8, 10, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (9, 11, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (10, 12, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (11, 13, N'unit1.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (12, 14, N'unit2.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (13, 15, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (14, 16, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (15, 17, N'unit1.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (16, 18, N'unit2.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (17, 19, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (18, 20, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (19, 21, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (20, 22, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (21, 23, N'unit1.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (22, 24, N'unit2.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (23, 25, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (24, 26, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (25, 27, N'unit1.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (26, 28, N'unit2.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (27, 29, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (28, 30, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (29, 31, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (30, 32, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (31, 33, N'unit1.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (32, 34, N'unit2.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (33, 35, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (34, 36, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (35, 37, N'unit1.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (36, 38, N'unit2.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (37, 39, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (38, 40, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (39, 41, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (40, 42, N'Unit4.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (41, 43, N'unit3.png')
INSERT [dbo].[Theory] ([TheoryID], [UnitID], [TheoryContent]) VALUES (42, 44, N'Unit4.png')
SET IDENTITY_INSERT [dbo].[Theory] OFF
SET IDENTITY_INSERT [dbo].[Units] ON 

INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (1, 1, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (2, 1, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (3, 1, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (4, 2, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (5, 2, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (6, 2, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (7, 3, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (10, 3, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (11, 3, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (12, 4, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (13, 4, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (14, 4, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (15, 5, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (16, 5, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (17, 5, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (18, 14, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (19, 14, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (20, 14, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (21, 15, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (22, 15, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (23, 15, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (24, 16, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (25, 16, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (26, 16, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (27, 17, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (28, 17, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (29, 17, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (30, 18, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (31, 18, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (32, 18, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (33, 19, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (34, 19, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (35, 19, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (36, 20, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (37, 20, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (38, 20, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (39, 21, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (40, 21, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (41, 21, N'Word skill')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (42, 22, N'Vocabulary')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (43, 22, N'Grammar')
INSERT [dbo].[Units] ([UnitID], [SubjectID], [UnitName]) VALUES (44, 22, N'Word skill')
SET IDENTITY_INSERT [dbo].[Units] OFF
SET IDENTITY_INSERT [dbo].[UserProfile] ON 

INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (1, 1, N'Nguyễn Văn Linh', CAST(N'1998-02-08' AS Date), 1, N'linhnxpd05401@gmail.com', N'0819515456', N'Quảng Bình', N'anh1.jpg', 1530, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (2, 2, N'Nguyễn Văn Linh', CAST(N'1998-02-08' AS Date), 1, N'linhnxpd05401@gmail.com', N'0819515456', N'Quảng Bình', NULL, 30, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (3, 3, N'Hùng Trần', CAST(N'1998-12-04' AS Date), 1, N'user01@gmail.com', N'0450540505', N'Quảng Trị', N'profile1.jpg', 950, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (6, 7, N'Trần Văn Linh', CAST(N'1998-02-08' AS Date), 1, N'nxlinh.12b10.pdl@gmail.com', N'0819515456', N'Quảng Bình', N'profile2.jpg', 10, CAST(N'2022-06-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (7, 8, N'Tran Huu quan', CAST(N'2000-12-02' AS Date), 1, N'bimzc123@gmail.com', N'0944940583', N'Quảng Trị', NULL, 10, CAST(N'2021-06-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (11, 9, N'Le Hoang Nam', CAST(N'1997-05-05' AS Date), 0, N'lhn123@gmail.com', N'0956847564', N'Quảng Ngãi', NULL, 15, CAST(N'2022-09-16' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (12, 11, N'Le Thi Mơ', CAST(N'1996-08-07' AS Date), 0, N'ltm111@gmail.com', N'0546854965', N'Quảng Nam', NULL, 188, CAST(N'2022-12-08' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (13, 12, N'AshiNomoTo', CAST(N'2005-08-07' AS Date), 1, N'akimo@gmail.com', N'0548765954', N'Nhật Bản', NULL, 1500, CAST(N'2022-01-06' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (15, 13, N'Trần Văn Bình', CAST(N'1996-06-27' AS Date), 1, N'tranvanbinh@gmail.com', N'0958468954', N'Đà Nẵng', N'anh2.jpg', 2, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (16, 15, N'Trần Hữu Quân', CAST(N'2000-02-12' AS Date), 1, N'quanthp05478@fpt.eu.vn', N'0944940583', N'Hà Tĩnh', N'anhnam3.jpg', 0, CAST(N'2022-06-04' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (17, 16, N'Thái Văn Minh', CAST(N'1995-05-05' AS Date), 1, N'thaivanminh@gmail.com', N'0956849876', N'Vinh', NULL, 100, CAST(N'2022-07-30' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (18, 17, N'Lê Văn Hùng', CAST(N'2003-03-03' AS Date), 1, N'lvhung@gmail.com', N'0955555666', N'Hà Nội', NULL, 150, CAST(N'2022-08-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (19, 18, N'Kai O Ken', CAST(N'1999-09-09' AS Date), 0, N'kasisama@gmail.com', N'0955666258', N'Nhật Bản', NULL, 560, CAST(N'2022-08-05' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (20, 19, N'Bim Ba Bi ', CAST(N'2000-07-06' AS Date), 1, N'bimzc123@gmail.com', N'0814759841', N'Hà Tĩnh', NULL, 500, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (22, 20, N'Mason', CAST(N'1998-02-08' AS Date), 1, N'linhnxpd05401@gmail.com', N'0819515456', N'Quảng Bình', NULL, 30, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (23, 21, N'Cato', CAST(N'1998-12-04' AS Date), 1, N'user01@gmail.com', N'0450540505', N'Quảng Trị', N'profile1.jpg', 950, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (24, 22, N'Gray', CAST(N'1998-02-08' AS Date), 1, N'nxlinh.12b10.pdl@gmail.com', N'0819515456', N'Quảng Bình', N'profile2.jpg', 10, CAST(N'2022-06-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (25, 23, N'Ace', CAST(N'2000-12-02' AS Date), 1, N'bimzc123@gmail.com', N'0944940583', N'Quảng Trị', NULL, 10, CAST(N'2021-06-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (26, 24, N'john', CAST(N'1997-05-05' AS Date), 0, N'lhn123@gmail.com', N'0956847564', N'Quảng Ngãi', NULL, 15, CAST(N'2022-09-16' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (27, 25, N'Linn', CAST(N'1996-08-07' AS Date), 0, N'ltm111@gmail.com', N'0546854965', N'Quảng Nam', NULL, 188, CAST(N'2022-12-08' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (28, 26, N'Anna', CAST(N'2005-08-07' AS Date), 1, N'akimo@gmail.com', N'0548765954', N'Nhật Bản', NULL, 1500, CAST(N'2022-01-06' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (29, 27, N'Hoàng Văn Cung', CAST(N'1996-06-27' AS Date), 1, N'tranvanbinh@gmail.com', N'0958468954', N'Đà Nẵng', N'anh2.jpg', 500, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (30, 28, N'Lê Thái', CAST(N'2000-02-12' AS Date), 1, N'quanthp05478@fpt.eu.vn', N'0944940583', N'Hà Tĩnh', N'anhnam3.jpg', 0, CAST(N'2022-06-04' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (31, 29, N'Trần Bình', CAST(N'1995-05-05' AS Date), 1, N'thaivanminh@gmail.com', N'0956849876', N'Vinh', NULL, 100, CAST(N'2022-07-30' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (32, 30, N'Xày A Chỏn', CAST(N'2003-03-03' AS Date), 1, N'lvhung@gmail.com', N'0955555666', N'Hà Nội', NULL, 150, CAST(N'2022-08-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (33, 31, N'Nimm', CAST(N'1999-09-09' AS Date), 0, N'kasisama@gmail.com', N'0955666258', N'Nhật Bản', NULL, 560, CAST(N'2022-08-05' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (34, 32, N'Josh', CAST(N'2000-07-06' AS Date), 1, N'bimzc123@gmail.com', N'0814759841', N'Hà Tĩnh', NULL, 500, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (35, 33, N'Dracula', CAST(N'1998-02-08' AS Date), 1, N'linhnxpd05401@gmail.com', N'0819515456', N'Quảng Bình', NULL, 30, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (36, 34, N'Hynna', CAST(N'1998-12-04' AS Date), 1, N'user01@gmail.com', N'0450540505', N'Quảng Trị', N'profile1.jpg', 950, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (37, 35, N'Lowe', CAST(N'1998-02-08' AS Date), 1, N'nxlinh.12b10.pdl@gmail.com', N'0819515456', N'Quảng Bình', N'profile2.jpg', 10, CAST(N'2022-06-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (38, 36, N'Yoe', CAST(N'2000-12-02' AS Date), 1, N'bimzc123@gmail.com', N'0944940583', N'Quảng Trị', NULL, 10, CAST(N'2021-06-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (39, 37, N'Kasadin', CAST(N'1997-05-05' AS Date), 0, N'lhn123@gmail.com', N'0956847564', N'Quảng Ngãi', NULL, 15, CAST(N'2022-09-16' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (40, 38, N'Yasuo', CAST(N'1996-08-07' AS Date), 0, N'ltm111@gmail.com', N'0546854965', N'Quảng Nam', NULL, 188, CAST(N'2022-12-08' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (41, 39, N'Illaoli', CAST(N'2005-08-07' AS Date), 1, N'akimo@gmail.com', N'0548765954', N'Nhật Bản', NULL, 1500, CAST(N'2022-01-06' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (42, 40, N'Master Yi', CAST(N'1996-06-27' AS Date), 1, N'tranvanbinh@gmail.com', N'0958468954', N'Đà Nẵng', N'anh2.jpg', 500, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (43, 41, N'Zed', CAST(N'2000-02-12' AS Date), 1, N'quanthp05478@fpt.eu.vn', N'0944940583', N'Hà Tĩnh', N'anhnam3.jpg', 0, CAST(N'2022-06-04' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (44, 42, N'Tristana', CAST(N'1995-05-05' AS Date), 1, N'thaivanminh@gmail.com', N'0956849876', N'Vinh', NULL, 100, CAST(N'2022-07-30' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (45, 43, N'Jinx', CAST(N'2003-03-03' AS Date), 1, N'lvhung@gmail.com', N'0955555666', N'Hà Nội', NULL, 150, CAST(N'2022-08-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (46, 44, N'Alistar', CAST(N'1999-09-09' AS Date), 0, N'kasisama@gmail.com', N'0955666258', N'Nhật Bản', NULL, 560, CAST(N'2022-08-05' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (47, 45, N'Akali', CAST(N'2000-07-06' AS Date), 1, N'bimzc123@gmail.com', N'0814759841', N'Hà Tĩnh', NULL, 500, CAST(N'2022-07-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (48, 46, N'Nidalee', CAST(N'2003-03-03' AS Date), 1, N'lvhung@gmail.com', N'0955555666', N'Hà Nội', NULL, 150, CAST(N'2022-08-01' AS Date))
INSERT [dbo].[UserProfile] ([UserID], [AccountID], [Name], [Birthday], [Gender], [Email], [PhoneNumber], [Address], [Image], [Coin], [RegistrasionDate]) VALUES (49, 47, N'Graves', CAST(N'1999-09-09' AS Date), 0, N'kasisama@gmail.com', N'0955666258', N'Nhật Bản', NULL, 560, CAST(N'2022-08-05' AS Date))
SET IDENTITY_INSERT [dbo].[UserProfile] OFF
ALTER TABLE [dbo].[Announce]  WITH CHECK ADD  CONSTRAINT [FK_Announce_UserProfile] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserProfile] ([UserID])
GO
ALTER TABLE [dbo].[Announce] CHECK CONSTRAINT [FK_Announce_UserProfile]
GO
ALTER TABLE [dbo].[AnswersAndQuestionsForExercise]  WITH CHECK ADD  CONSTRAINT [FK_AnswersAndQuestionsForExercise_Subject] FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subject] ([SubjectID])
GO
ALTER TABLE [dbo].[AnswersAndQuestionsForExercise] CHECK CONSTRAINT [FK_AnswersAndQuestionsForExercise_Subject]
GO
ALTER TABLE [dbo].[AnswersAndQuestionsForTest]  WITH CHECK ADD  CONSTRAINT [FK_AnswersAndQuestionsForTest_Test] FOREIGN KEY([TestID])
REFERENCES [dbo].[Test] ([TestID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[AnswersAndQuestionsForTest] CHECK CONSTRAINT [FK_AnswersAndQuestionsForTest_Test]
GO
ALTER TABLE [dbo].[LearningProcess]  WITH CHECK ADD  CONSTRAINT [FK_LearningProcess_Subject] FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subject] ([SubjectID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[LearningProcess] CHECK CONSTRAINT [FK_LearningProcess_Subject]
GO
ALTER TABLE [dbo].[LearningProcess]  WITH CHECK ADD  CONSTRAINT [FK_LearningProcess_UserProfile] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserProfile] ([UserID])
GO
ALTER TABLE [dbo].[LearningProcess] CHECK CONSTRAINT [FK_LearningProcess_UserProfile]
GO
ALTER TABLE [dbo].[Rate]  WITH CHECK ADD  CONSTRAINT [FK_Rate_UserProfile] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserProfile] ([UserID])
GO
ALTER TABLE [dbo].[Rate] CHECK CONSTRAINT [FK_Rate_UserProfile]
GO
ALTER TABLE [dbo].[TestingProcess]  WITH CHECK ADD  CONSTRAINT [FK_TestingProcess_Test] FOREIGN KEY([TestID])
REFERENCES [dbo].[Test] ([TestID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[TestingProcess] CHECK CONSTRAINT [FK_TestingProcess_Test]
GO
ALTER TABLE [dbo].[TestingProcess]  WITH CHECK ADD  CONSTRAINT [FK_TestingProcess_UserProfile] FOREIGN KEY([UserID])
REFERENCES [dbo].[UserProfile] ([UserID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[TestingProcess] CHECK CONSTRAINT [FK_TestingProcess_UserProfile]
GO
ALTER TABLE [dbo].[Theory]  WITH CHECK ADD  CONSTRAINT [FK_Theory_Units] FOREIGN KEY([UnitID])
REFERENCES [dbo].[Units] ([UnitID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Theory] CHECK CONSTRAINT [FK_Theory_Units]
GO
ALTER TABLE [dbo].[Units]  WITH CHECK ADD  CONSTRAINT [FK_Units_Subject] FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subject] ([SubjectID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Units] CHECK CONSTRAINT [FK_Units_Subject]
GO
ALTER TABLE [dbo].[UserProfile]  WITH CHECK ADD  CONSTRAINT [FK_UserProfile_Accounts] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[UserProfile] CHECK CONSTRAINT [FK_UserProfile_Accounts]
GO
/****** Object:  StoredProcedure [dbo].[SP_MANAGER_USER_OVERALL]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_MANAGER_USER_OVERALL]
AS BEGIN
SELECT A.NAME,A.USERID,A.COIN,COUNT(C.UserID) AS 'TESTDONE',COUNT(D.UserID) AS'SUBJECTLEARNED',SUM(D.Mark) AS 'SUMMARKLEARN',SUM(C.Mark) AS 'SUMTESTMARK' FROM UserProfile A
INNER JOIN Accounts B ON A.AccountID = B.AccountID
INNER JOIN TestingProcess C ON A.UserID = C.UserID
INNER JOIN LearningProcess D ON A.UserID = D.UserID
WHERE B.Role = '0'AND C.Status = '1' AND D.Status ='1'
GROUP BY C.UserID,A.Name,A.UserID,A.Coin,D.UserID
END
GO
/****** Object:  StoredProcedure [dbo].[SP_OVERALL_COIN_AND_MARK]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_OVERALL_COIN_AND_MARK]
AS BEGIN
SELECT B.Name ,B.Coin,A.UserID,SUM(A.Mark) as 'Sum_Mark' FROM LearningProcess A
INNER JOIN UserProfile B ON A.UserID = B.UserID
GROUP BY A.UserID,B.Name,B.Coin
END
GO
/****** Object:  StoredProcedure [dbo].[SP_STATISTICAL_SUBJECT]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_STATISTICAL_SUBJECT]
AS BEGIN
select B.SubjectName,A.SubjectID,COUNT(a.SubjectID) as 'TIMES',MAX(A.Mark) AS 'HIGHTEST' , MIN(A.Mark) AS 'LOWEST' from LearningProcess a
INNER JOIN Subject B ON A.SubjectID = B.SubjectID
GROUP BY B.SubjectName,A.SubjectID
END
GO
/****** Object:  StoredProcedure [dbo].[SP_STATISTICAL_TEST]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_STATISTICAL_TEST]
AS BEGIN
select c.TestName,a.TestID,COUNT(a.TestID)as 'Times',max(a.Mark)as'Hightest',MIN(a.Mark) as 'Lowest' from TestingProcess a
inner join Test c on c.TestID = a.TestID
GROUP BY C.TestName,A.TestID
END
GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeNguoiHoc]    Script Date: 01/08/2022 12:29:44 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ThongKeNguoiHoc]
AS BEGIN
	SELECT
		MONTH(RegistrasionDate) as Month,
		COUNT(*) as 'User_Number'
	FROM UserProfile
	GROUP BY MONTH(RegistrasionDate)
	ORDER BY MONTH(RegistrasionDate) ASC
END;
GO
USE [master]
GO
ALTER DATABASE [TheLEAAcademy] SET  READ_WRITE 
GO
