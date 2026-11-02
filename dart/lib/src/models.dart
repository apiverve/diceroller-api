/// Response models for the Dice Roller API.

/// API Response wrapper.
class DicerollerResponse {
  final String status;
  final dynamic error;
  final DicerollerData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  DicerollerResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory DicerollerResponse.fromJson(Map<String, dynamic> json) => DicerollerResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DicerollerData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Dice Roller API.

class DicerollerData {
  String? diceNotation;
  num? numDice;
  num? numSides;
  num? modifier;
  List<num>? rolls;
  num? total;
  num? totalWithModifier;
  num? minRoll;
  num? maxRoll;
  num? averageRoll;
  num? theoreticalMin;
  num? theoreticalMax;
  num? theoreticalAverage;
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
      rolls: (json['rolls'] as List?)?.cast<num>(),
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
