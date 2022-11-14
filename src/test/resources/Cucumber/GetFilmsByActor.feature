Feature: retrieves movies an actor has starred in
    as a user, I would like to see other movies the actor has been in

  Scenario: Successfully retrieved the movies an actor has starred in
    Given a users desired actor
    When the user searches using the actor
    Then the movies starring the actor should be retrieved