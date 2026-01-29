# 🏠 Household Budget Management System

## Présentation
Le projet **Household Budget Management System** est une application web intelligente conçue pour la gestion des finances familiales. Elle permet aux membres d'une famille de suivre leurs dépenses en temps réel et de bénéficier de recommandations personnalisées grâce à un **Agent IA** (Agentic AI) capable d'analyser les habitudes de consommation pour optimiser l'épargne.

## Architecture du Système
L'application repose sur une architecture moderne en micro-services conteneurisés, assurant une séparation nette entre l'interface utilisateur, la logique métier et le moteur d'intelligence artificielle.

```mermaid
graph TD
    %% Partie Utilisateur
    User((Utilisateur / Famille)) -->|Interagit| Angular

    subgraph "Frontend (Docker Container)"
        Angular[Interface Angular + Tailwind]
        Dash[Dashboard & Chat IA]
        Angular --> Dash
    end

    subgraph "Backend (Docker Container)"
        Spring[Spring Boot App]
        Security[Spring Security + JWT Filter]
        Service[Budget & AI Service]
        
        Spring --> Security
        Security --> Service
    end

    subgraph "Persistance"
        MySQL[(Base de Données MySQL)]
    end

    subgraph "Intelligence Artificielle"
        AgentIA[Agent IA / Prompt Engineering]
        LLM[API LLM Externe]
    end

    %% Flux
    Angular <-->|Requêtes REST + JWT| Spring
    Service <-->|SQL| MySQL
    Service <-->|Prompt Data| AgentIA
    AgentIA <-->|API Request| LLM