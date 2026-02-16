/// Response models for the Dice Roller API.

/// API Response wrapper.
class DicerollerResponse {
  final String status;
  final dynamic error;
  final DicerollerData? data;

  DicerollerResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory DicerollerResponse.fromJson(Map<String, dynamic> json) => DicerollerResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DicerollerData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Dice Roller API.

class DicerollerData {
  String? diceNotation;
  int? numDice;
  int? numSides;
  int? modifier;
  List<int>? rolls;
  int? total;
  int? totalWithModifier;
  int? minRoll;
  int? maxRoll;
  double? averageRoll;
  int? theoreticalMin;
  int? theoreticalMax;
  double? theoreticalAverage;
  String? expression;

  DicerollerData({
    this.diceNotation,
    this.numDice,
    this.numSides,
    this.modifier,
    this.rolls,
    this.total,
    this.totalWithModifier,
    this.minRoll,
    this.maxRoll,
    this.averageRoll,
    this.theoreticalMin,
    this.theoreticalMax,
    this.theoreticalAverage,
    this.expression,
  });

  factory DicerollerData.fromJson(Map<String, dynamic> json) => DicerollerData(
      diceNotation: json['dice_notation'],
      numDice: json['num_dice'],
      numSides: json['num_sides'],
      modifier: json['modifier'],
      rolls: (json['rolls'] as List?)?.cast<int>(),
      total: json['total'],
      totalWithModifier: json['total_with_modifier'],
      minRoll: json['min_roll'],
      maxRoll: json['max_roll'],
      averageRoll: json['average_roll'],
      theoreticalMin: json['theoretical_min'],
      theoreticalMax: json['theoretical_max'],
      theoreticalAverage: json['theoretical_average'],
      expression: json['expression'],
    );
}

class DicerollerRequest {
  String? dice;
  int? modifier;

  DicerollerRequest({
    this.dice,
    this.modifier,
  });

  Map<String, dynamic> toJson() => {
      if (dice != null) 'dice': dice,
      if (modifier != null) 'modifier': modifier,
    };
}
