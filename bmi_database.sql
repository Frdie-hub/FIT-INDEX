-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2025 at 09:18 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bmi_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`) VALUES
(1, 'admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `routines`
--

CREATE TABLE `routines` (
  `ID` int(11) NOT NULL,
  `Routine_type` varchar(255) NOT NULL,
  `Routine_desc` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `routines`
--

INSERT INTO `routines` (`ID`, `Routine_type`, `Routine_desc`) VALUES
(1, 'Underweight', 'YOU ARE UNDERWEIGHT\r\n🥗 1. Nutrition: Your #1 Priority\r\nTo gain healthy weight, you need to eat more calories than you burn — but focus on nutrient-dense foods, not just junk.\r\nFocus on:\r\nHigh-calorie, high-protein meals (every 3–4 hours)\r\nHealthy fats: nuts, seeds, avocado, olive oil\r\nComplex carbs: brown rice, oats, sweet potatoes, whole grain bread\r\nProtein: chicken, eggs, fish, Greek yogurt, tofu, lentils, whey protein\r\nCalorie boosters: smoothies with peanut butter, milk, oats, banana, protein powder\r\nGoal: Aim for a caloric surplus of 300–500 calories/day.\r\n🏋️‍♂️ 2. Strength Training (3–5x/week)\r\nBuild muscle with progressive overload (lifting heavier over time).\r\nSample Weekly Split:\r\nDay 1 – Push (Chest, Shoulders, Triceps)\r\nDay 2 – Pull (Back, Biceps)\r\nDay 3 – Legs (Quads, Hamstrings, Glutes)\r\nDay 4 – Rest or Full Body\r\nDay 5 – Repeat or Active Recovery\r\nKey Exercises:\r\nCompound lifts: Squats, deadlifts, bench press, pull-ups, rows, overhead press\r\nAccessory work: Dumbbell curls, lateral raises, triceps extensions\r\nTip: Keep cardio light (2–3x/week) to avoid burning too many calories.\r\n😴 3. Recovery and Sleep\r\nMuscle growth happens outside the gym, especially while sleeping.\r\nGet 7–9 hours of quality sleep\r\nTake rest days seriously\r\nAvoid overtraining\r\n📈 4. Track Your Progress\r\nWeigh yourself weekly\r\nTake progress photos monthly\r\nTrack your lifts (use a workout log or app)\r\n💡 Bonus Tips:\r\nConsider a mass gainer if you\'re struggling to eat enough\r\nDon\'t skip breakfast or post-workout meals\r\nBe consistent — results take time\r\n🗓️ Daily Meal Plan (Approx. 2,800–3,000 calories)\r\nAdjust portion sizes if you need more/less.\r\n🥣 Breakfast (700–800 kcal)\r\nProtein Oats Smoothie:\r\n1 cup whole milk or plant milk\r\n1 banana\r\n½ cup oats\r\n2 tbsp peanut butter\r\n1 scoop protein powder or 3 tbsp Greek yogurt\r\n1 tsp honey\r\nHandful of spinach (optional)\r\n+ 1 Boiled egg or toast with butter\r\n🍱 Lunch (750–850 kcal)\r\nGrilled Chicken Rice Bowl:\r\n1 cup cooked brown or white rice\r\n1 chicken breast (or tofu)\r\n½ avocado\r\nSteamed broccoli or carrots\r\nOlive oil drizzle (1 tbsp)\r\n+ 1 fruit (e.g., apple or orange)\r\n🥜 Snack (400–500 kcal)\r\nNutty Yogurt Bowl:\r\n1 cup full-fat Greek yogurt\r\n2 tbsp granola\r\n1 tbsp honey\r\nHandful of almonds or walnuts\r\nBerries (fresh or frozen)\r\n🍝 Dinner (750–850 kcal)\r\nPasta with Protein:\r\n2 cups cooked pasta\r\n1 cup lean ground beef, turkey, or lentils\r\nTomato sauce\r\n1 tbsp olive oil\r\nSide salad with dressing or garlic bread\r\n🥛 Evening Snack (400 kcal)\r\nMuscle Milkshake:\r\n1 cup whole milk\r\n1 scoop protein powder\r\n1 tbsp peanut butter\r\n½ banana\r\nDash of cinnamon or cocoa\r\n💧 Hydration:\r\nDrink plenty of water throughout the day\r\nYou can add milk or 100% fruit juice with meals for extra calorie'),
(2, 'Normal', 'YOUR BMI IS NORMAL!!!!\r\n🔍 Step 1: Define Your Goal\r\nWhich of these best describes what you want?\r\n\r\n✅ Maintain your current weight and improve overall fitness\r\n\r\n💪 Build muscle and strength\r\n\r\n🏃 Improve cardiovascular endurance or athletic performance\r\n\r\n🧘‍♀️ Enhance flexibility, mobility, and stress relief\r\n\r\n🧼 Tone up / improve body composition\r\n\r\n📋 Step 2: Sample Routine for Each Goal\r\n✅ 1. General Fitness (Maintenance)\r\nRoutine: 3–5x/week mixed training\r\n\r\n2x Strength (Full-body workouts)\r\n\r\n2x Cardio (Jog, bike, swim, or HIIT)\r\n\r\n1x Mobility/Yoga\r\n\r\nGoal: Balanced health, energy, and fitness\r\n\r\n💪 2. Muscle Building\r\nRoutine: 4–5x/week strength training\r\n\r\nDay 1 – Push (Chest, Shoulders, Triceps)\r\n\r\nDay 2 – Pull (Back, Biceps)\r\n\r\nDay 3 – Legs\r\n\r\nDay 4 – Rest or Active Recovery\r\n\r\nDay 5 – Full Body or Repeat\r\n\r\nAdd: 1–2 short cardio sessions to support heart health\r\n\r\nNutrition: Eat in a slight calorie surplus + high protein\r\n\r\n🏃 3. Endurance/Cardio Focus\r\nRoutine: 4–6x/week aerobic training\r\n\r\n3–4x Running, Cycling, Rowing, Swimming\r\n\r\n1–2x Strength (focus on core and legs)\r\n\r\nOptional: HIIT, Yoga, Stretching\r\n\r\nNutrition: Balanced diet, enough carbs for fuel\r\n\r\n🧘 4. Mobility & Stress Relief\r\nRoutine: 3–6x/week low-impact training\r\n\r\n3x Yoga/Pilates/Mobility work\r\n\r\n2–3x Light strength or bodyweight exercises\r\n\r\nDaily walking and breathing exercises\r\n\r\nGoal: Reduce tension, improve posture and joint health\r\n\r\n🧼 5. Toning / Body Recomposition\r\nRoutine: 4–5x/week\r\n\r\n3x Strength Training\r\n\r\n2x Cardio (HIIT or moderate intensity)\r\n\r\nDaily walking + occasional yoga or stretching\r\n\r\nNutrition: Slight calorie deficit, high protein\r\n\r\n🧠 Tips Regardless of Your Goal\r\nWarm up before every workout (5–10 mins)\r\n\r\nStretch or foam roll after\r\n\r\nPrioritize sleep (7–9 hrs)\r\n\r\nStay hydrated and eat whole, nutrient-dense foods'),
(3, 'Overweight', 'YOU ARE OVERWEIGHT!!!\r\n1. Exercise Routine for Overweight\r\nAim: Burn calories, build strength, improve endurance without injury\r\n🏃‍♂️ Cardio (3–5x/week)\r\nStart with low-impact options like walking, cycling, swimming, or elliptical to protect joints.\r\n\r\nDuration: 20–45 minutes\r\n\r\nGradually increase intensity or time as you get fitter.\r\n\r\nInclude interval training (HIIT) once comfortable for better fat burn.\r\n\r\n🏋️ Strength Training (2–3x/week)\r\nFocus on full-body workouts with compound movements: squats, push-ups (can be on knees), rows, lunges, and planks.\r\n\r\nUse bodyweight or light weights/resistance bands.\r\n\r\nHelps preserve and build muscle, which boosts metabolism.\r\n\r\n🤸 Flexibility & Mobility (Daily or every other day)\r\nGentle stretching or yoga for joint health and injury prevention.\r\n\r\n🥗 2. Nutrition for Fat Loss\r\nAim for a calorie deficit (eat fewer calories than you burn) — typically reduce by 300–500 kcal/day.\r\n\r\nFocus on whole foods: veggies, lean protein, whole grains, healthy fats.\r\n\r\nAvoid or limit processed foods, sugary drinks, and excessive snacking.\r\n\r\nEat smaller, frequent meals to manage hunger.\r\n\r\nDrink plenty of water.\r\n\r\n😴 3. Lifestyle & Recovery\r\nPrioritize 7–9 hours of sleep per night — poor sleep can hurt weight loss.\r\n\r\nManage stress through meditation, walking, or hobbies.\r\n\r\nTrack your progress with weekly weigh-ins or measurements, but don’t obsess.\r\n\r\n🗓️ Sample Weekly Routine (Beginner Friendly)\r\nDay	Activity\r\nMonday	30 min brisk walking + full-body strength\r\nTuesday	Rest or light yoga/stretching\r\nWednesday	30–40 min cycling or swimming\r\nThursday	Full-body strength training\r\nFriday	Rest or easy walk\r\nSaturday	30 min interval walking/jogging\r\nSunday	Mobility work + stretching\r\n\r\n💡 Bonus Tips\r\nWear comfortable shoes and clothes.\r\n\r\nFind a workout buddy or group for motivation.\r\n\r\nCelebrate non-scale victories: better mood, more energy, improved sleep.'),
(4, 'Obese', 'DO NOT WORRY WE WILL GET THERE!!\r\n🚦 Key Principles for Exercising with Obesity\r\nStart slow: Focus on low-impact activities\r\n\r\nPrioritize joint-friendly moves: Avoid high-impact running or jumping initially\r\n\r\nBuild endurance gradually: Short sessions with rest as needed\r\n\r\nCombine cardio + strength for best results\r\n\r\nFocus on consistency over intensity\r\n\r\n🏃‍♂️ Recommended Exercises\r\n1. Walking\r\nStart with 10–15 minutes at a comfortable pace\r\n\r\nGradually increase duration and speed over weeks\r\n\r\nUse a treadmill or flat outdoor paths\r\n\r\n2. Water Aerobics / Swimming\r\nGreat for reducing joint impact\r\n\r\nBurns calories and builds cardiovascular health\r\n\r\nTry classes or swim laps at your own pace\r\n\r\n3. Cycling (Stationary or Outdoor)\r\nLow-impact, easy on knees and hips\r\n\r\nStart with 10–20 minutes, then build up\r\n\r\n4. Chair Exercises / Seated Workouts\r\nArm raises, leg lifts, seated marching\r\n\r\nGood for building strength if mobility is limited\r\n\r\n5. Strength Training (2–3x/week)\r\nUse bodyweight or resistance bands\r\n\r\nFocus on major muscle groups: legs, chest, back, core\r\n\r\nExamples: wall push-ups, seated leg lifts, resistance band rows\r\n\r\n6. Gentle Yoga or Stretching\r\nImprove flexibility and reduce stiffness\r\n\r\nHelps with balance and posture\r\n\r\n📋 Sample Beginner Weekly Routine\r\nDay	Activity\r\nMonday	15–20 min walking + gentle stretching\r\nTuesday	Chair exercises + light strength training\r\nWednesday	Rest or water aerobics/swimming\r\nThursday	15–20 min cycling or walking\r\nFriday	Strength training + yoga/stretching\r\nSaturday	Rest or easy walk\r\nSunday	Mobility exercises + light cardio\r\n\r\n📝 Additional Tips\r\nWarm up and cool down with 5–10 minutes of light movement or stretching.\r\n\r\nWear supportive footwear.\r\n\r\nListen to your body; stop if you feel pain.\r\n\r\nSet small, realistic goals (e.g., add 5 minutes of walking each week).\r\n\r\nConsult your healthcare provider before starting, especially if you have other conditions.');

-- --------------------------------------------------------

--
-- Table structure for table `userroutine`
--

CREATE TABLE `userroutine` (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Age` varchar(100) NOT NULL,
  `Height` float NOT NULL,
  `Weight` float NOT NULL,
  `Bmi` float NOT NULL,
  `Routine` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Name` varchar(250) NOT NULL,
  `Age` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
