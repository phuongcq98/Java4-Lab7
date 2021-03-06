USE [master]
GO
/****** Object:  Database [lab7]    Script Date: 12/02/2018 23:32:03 ******/
CREATE DATABASE [lab7] ON  PRIMARY 
( NAME = N'lab7', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\lab7.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'lab7_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\lab7_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [lab7] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [lab7].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [lab7] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [lab7] SET ANSI_NULLS OFF
GO
ALTER DATABASE [lab7] SET ANSI_PADDING OFF
GO
ALTER DATABASE [lab7] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [lab7] SET ARITHABORT OFF
GO
ALTER DATABASE [lab7] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [lab7] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [lab7] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [lab7] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [lab7] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [lab7] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [lab7] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [lab7] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [lab7] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [lab7] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [lab7] SET  DISABLE_BROKER
GO
ALTER DATABASE [lab7] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [lab7] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [lab7] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [lab7] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [lab7] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [lab7] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [lab7] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [lab7] SET  READ_WRITE
GO
ALTER DATABASE [lab7] SET RECOVERY SIMPLE
GO
ALTER DATABASE [lab7] SET  MULTI_USER
GO
ALTER DATABASE [lab7] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [lab7] SET DB_CHAINING OFF
GO
USE [lab7]
GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 12/02/2018 23:32:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[MAKH] [nvarchar](50) NOT NULL,
	[MATKHAU] [nvarchar](50) NULL,
	[HOVATEN] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[EMAIL] [nvarchar](50) NULL,
 CONSTRAINT [PK_KHACHHANG] PRIMARY KEY CLUSTERED 
(
	[MAKH] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
